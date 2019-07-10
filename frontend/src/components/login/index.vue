<template>
  <section id="wrapper" class="login-register">
    <div class="login-box login-sidebar">
      <div class="white-box">
        <msgs :mensagens="mensagens" :mensagemTipo="mensagemTipo" v-if="mensagens.length > 0 && mensagemTipo !== null"></msgs>

        <form class="form-horizontal form-material" @submit.prevent="login">
          <a href="javascript:void(0)" class="text-center db"><img src="@/assets/img/logo.png" class="login-logo" alt="Home" /></a>  

          <div class="form-group m-t-40" v-bind:class="{'has-error':(validacaoError && util.isNullOrEmpty(cpf_cnpj))}">
            <div class="col-xs-12">
              <the-mask :mask="['###.###.###-##']" :masked="true" class="form-control" placeholder="CPF" v-model="cpf_cnpj" tabindex="1" />
            </div>
          </div>
          <div class="form-group" v-bind:class="{'has-error':(validacaoError && util.isNullOrEmpty(senha))}">
            <div class="col-xs-12">
              <input class="form-control" type="password" v-model="senha" placeholder="Senha" tabindex="2">
            </div>
          </div>
          <div class="form-group text-center m-t-20">
            <div class="col-xs-12">
              <button class="btn btn-info btn-lg btn-block text-uppercase waves-effect waves-light" type="submit" tabindex="3">Acessar</button>
            </div>
          </div>
        </form>
      </div>
    </div>
  </section>
</template>

<style>
  .login {
    display: flex;
    flex-direction: column;
    width: 300px;
    padding: 10px;
  }
</style>

<script>
  import {AUTH_REQUEST} from '@/store/actions/auth'

  // import axios from 'axios'
  import {AXIOS} from './../http-common'

  // Mask
  import {TheMask} from 'vue-the-mask'

  // Apresentação de mensagens 
  import Msgs from '../elements/Msgs.vue'

  import {Util} from '@/helpers/Util.js'

  export default {
    name: 'login',
    components: {
        TheMask,
        Msgs
    },
    data () {
      return {
        mensagemTipo: null,
        mensagens: [],
        util: new Util(),
        validacaoError: false,
        validacaoCpfError: false,
        cpf_cnpj: '',
        senha: ''
      }
    },
    methods: {
      async login() {

        if(this.validarLogin()){

          const { cpf_cnpj, senha } = this

          $("#preloader").show()

          await AXIOS.post(`/autenticacao/verificarDadosLogin`, {cpf_cnpj: cpf_cnpj, senha: senha})
          .then(response => {
            var res = response.data
            if(res !== null && res !== ""){
              localStorage.setItem('usuarioLogado', JSON.stringify(res))
              this.$store.dispatch(AUTH_REQUEST, { cpf_cnpj, senha }).then(() => {
                this.$router.push('/')
                $("#preloader").hide()
              })
            }else {
              $("#preloader").hide()
              swal("Error!", "Usuario ou senha inválidos.", "error")
            }
          })
          .catch(e => {
              $("#preloader").hide()
              swal("Error!", "Erro interno na aplicação.", "error")
              console.log('e', e)
          })

        }

      },
      validarLogin () {

        this.mensagens = []

        if(this.util.isNullOrEmpty(this.cpf_cnpj) || !this.util.validarCpf(this.cpf_cnpj)){
            this.mensagens.push("CPF <i>não preenchido ou inválido</i>.")
        }

        if(this.util.isNullOrEmpty(this.senha)){
            this.mensagens.push("Senha <i>não preenchida</i>.")
        }

        if(this.mensagens.length === 0){
            return true
        }else {
            this.mensagemTipo = 3
            this.validacaoError = true
        }

        $("html, body").animate({ scrollTop: 0 }, "slow")

      }
    }
  }
</script>