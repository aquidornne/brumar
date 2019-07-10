<template>
  <div id="cadastrar_ocupacao">
    <!-- Page Content -->
    <div id="page-wrapper">
        <div class="container-fluid">
            <div class="row bg-title">
                <!-- .page title -->
                <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                    <h4 class="page-title">Registrar Ocupação</h4>
                </div>
                <!-- /.page title -->
                <!-- .breadcrumb -->
                <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
                    <ol class="breadcrumb">
                        <li><router-link to="/">Início</router-link></li>
                        <li><router-link to="/ocupacoes/">Ocupações</router-link></li>
                        <li class="active">Cadastrar</li>
                    </ol>
                </div>
                <!-- /.breadcrumb -->
            </div>

            <!--.row-->
            <div class="row m-b-20 text-right">
                <div class="col-lg-12">
                    <router-link to="/ocupacoes/" class="btn btn-default waves-effect waves-light"><i class="fa fa-chevron-left"></i> Voltar</router-link>
                </div>
            </div>
            <!--/row-->

            <msgs :mensagens="mensagens" :mensagemTipo="mensagemTipo" v-if="mensagens.length > 0 && mensagemTipo !== null"></msgs>

            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">Registrar Ocupação</div>
                        <div class="panel-wrapper collapse in" aria-expanded="true">
                            <div class="panel-body">
                                <form action="#" class="form-horizontal">
                                    <div class="form-body">
                                        <!--.row-->
                                        <div class="row">
                                            <!--.span-->
                                            <div class="col-md-6">
                                                <div class="form-group" :class="{'has-error':(validacaoError && util.isNullOrEmpty(Ocupacoes.quarto_id))}">
                                                    <label class="col-md-12">Quarto <span class="text-danger">*</span></label>
                                                    <div class="col-md-12">
                                                        <v-select v-model="Combos.quartos" :options="quartosLista" placeholder="Selecione..." tabindex="1">
                                                            <span slot="no-options">Nenhum resultado encontrado.</span>
                                                        </v-select>
                                                    </div>
                                                </div>
                                            </div>
                                            <!--/span-->
                                            <!--.span-->
                                            <div class="col-md-6" :class="{'has-error':(validacaoError && util.isNullOrEmpty(Ocupacoes.dt_checkin))}">
                                                <div class="form-group">
                                                    <label class="col-md-12">Checkin <span class="text-danger">*</span></label>
                                                    <div class="col-md-12">
                                                        <the-mask :mask="['##/##/####']" :masked="true" class="form-control" placeholder="Checkin" v-model="Ocupacoes.dt_checkin" tabindex="2" />
                                                    </div>
                                                </div>
                                            </div>
                                            <!--/span-->
                                        </div>
                                        <!--/row-->
                                        <!--.row-->
                                        <div class="row">
                                            <!--.span-->
                                            <div class="col-md-6">
                                                <div class="form-group" :class="{'has-error':(validacaoError && util.isNullOrEmpty(Ocupacoes.tp_ocupacao))}">
                                                    <label class="col-md-12">Tipo de hospedagem <span class="text-danger">*</span></label>
                                                    <div class="col-md-12">
                                                        <v-select v-model="Combos.tp_ocupacao" :options="tiposOcupacaoLista" placeholder="Selecione..." tabindex="3">
                                                            <span slot="no-options">Nenhum resultado encontrado.</span>
                                                        </v-select>
                                                    </div>
                                                </div>
                                            </div>
                                            <!--/span-->
                                            <!--.span-->
                                            <div class="col-md-6" :class="{'has-error':(validacaoError && util.isNullOrEmpty(Ocupacoes.qtd_dias))}">
                                                <div class="form-group">
                                                    <label class="col-md-12">Dias de estadia <span class="text-danger">*</span></label>
                                                    <div class="col-md-12">
                                                        <the-mask :mask="['####']" :masked="true" class="form-control" placeholder="Dias de estadia" v-model="Ocupacoes.qtd_dias" tabindex="4" />
                                                    </div>
                                                </div>
                                            </div>
                                            <!--/span-->
                                        </div>
                                        <!--/row-->
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">Pessoas</div>
                        <div class="panel-wrapper collapse in" aria-expanded="true">
                            <div class="panel-body">
                                <!--.row-->
                                <div class="row">
                                    <!--.span-->
                                    <div class="col-md-6">
                                        <div class="form-group" :class="{'has-error':(validacaoErrorPessoa && util.isNullOrEmpty(PessoasDTO.nm_pessoa))}">
                                            <label class="col-md-12">Nome completo <span class="text-danger">*</span></label>
                                            <div class="col-md-12">
                                                <input type="text" class="form-control" v-model="PessoasDTO.nm_pessoa" placeholder="Nome" tabindex="5">
                                            </div>
                                        </div>
                                    </div>
                                    <!--/span-->
                                    <!--.span-->
                                    <div class="col-md-6">
                                        <div class="form-group" :class="{'has-error':(validacaoErrorPessoa && util.isNullOrEmpty(PessoasDTO.email))}">
                                            <label class="col-md-12">E-mail <span class="text-danger">*</span></label>
                                            <div class="col-md-12">
                                                <input type="text" class="form-control" v-model="PessoasDTO.email" placeholder="Email" tabindex="5">
                                            </div>
                                        </div>
                                    </div>
                                    <!--/span-->
                                    <!--.span-->
                                    <div class="col-md-6">
                                        <div class="form-group" :class="{'has-error':(validacaoErrorPessoa && util.isNullOrEmpty(PessoasDTO.dt_nascimento))}">
                                            <label class="col-md-12">Data de nascimento <span class="text-danger">*</span></label>
                                            <div class="col-md-12">
                                                <the-mask :mask="['##/##/####']" :masked="true" class="form-control" placeholder="Data de nascimento" v-model="PessoasDTO.dt_nascimento" tabindex="6" />
                                            </div>
                                        </div>
                                    </div>
                                    <!--/span-->
                                    <!--.span-->
                                    <div class="col-md-6">
                                        <div class="form-group" :class="{'has-error':(validacaoErrorPessoa && util.isNullOrEmpty(PessoasDTO.nu_cpf))}">
                                            <label class="col-md-12">CPF <span class="text-danger">*</span></label>
                                            <div class="col-md-12">
                                                <the-mask :mask="['###.###.###-##']" :masked="true" class="form-control" placeholder="CPF" v-model="PessoasDTO.nu_cpf" tabindex="7" />
                                            </div>
                                        </div>
                                    </div>
                                    <!--/span-->
                                </div>
                                <!--/row-->
                                <div class="form-actions m-b-20">
                                    <!--.row-->
                                    <div class="row">
                                        <div class="col-md-8"></div>
                                        <div class="col-md-4">
                                            <button class="btn btn-default m-r-10" @click="limparPessoasDTO">Cancelar</button>
                                            <button type="submit" class="btn btn-success" @click="adicionarPessoa">Adicionar</button>
                                        </div>
                                    </div>
                                    <!--/row-->
                                </div>

                                <div class="table-responsive">
                                    <table class="table muted-bordered-table table-bordered table-hover">
                                        <thead>
                                            <tr>
                                                <th><b>Nome</b></th>
                                                <th><b>E-mail</b></th>
                                                <th><b>Data de nascimento</b></th>
                                                <th><b>CPF</b></th>
                                                <th class="text-center"><b>Ações</b></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr v-for="(valor, chave) in Pessoas" v-bind:key="valor">
                                                <td>{{valor.nm_pessoa}}</td>
                                                <td>{{valor.email}}</td>
                                                <td>{{valor.dt_nascimento}}</td>
                                                <td>{{valor.nu_cpf}}</td>
                                                <td class="text-nowrap text-center">
                                                    <button class="btn btn-default btn-outline btn-1b m-r-10" v-tooltip.top="'Excluir'" @click="excluirPessoa(chave)">
                                                        <i class="fa fa-trash text-inverse"></i>
                                                    </button>
                                                </td>
                                            </tr>
                                            <tr v-if="Pessoas[0] === undefined">
                                                <td colspan="5">Nenhum registro encontrado.</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="form-actions">
                <!--.row-->
                <div class="row">
                    <div class="col-md-8"></div>
                    <div class="col-md-4">
                        <router-link to="/ocupacoes/" class="btn btn-default m-r-10">Cancelar</router-link>
                        <button type="submit" class="btn btn-success" @click="adicionarOcupacao" :disabled="registroAdicionado"><i class="fa fa-save"></i> Salvar Tudo</button>
                    </div>
                </div>
                <!--/row-->
            </div>

        </div>
    </div> 
  </div>
</template>

<script>
  // Imports
  import vSelect from 'vue-select'

  // import axios from 'axios'
  import {AXIOS} from './../http-common'

  // Mask
  import {TheMask} from 'vue-the-mask'

  // Apresentação de mensagens 
  import Msgs from '../elements/Msgs.vue'

  import {Util} from '@/helpers/Util.js'

  export default {
    name: 'cadastrar_ocupacao',
    components: {
        vSelect,
        TheMask,
        Msgs
    },
    data () {
      return {
        registroAdicionado: false,
        mensagemTipo: null,
        mensagens: [],
        util: new Util(),
        validacaoError: false,
        validacaoErrorPessoa: false,
        Ocupacoes: {
            in_ativo: true
        },
        Pessoas: [],
        PessoasDTO: {},
        Combos: {
            quartos : null,
            tp_ocupacao: null
        },
        quartosLista : [],
        tiposOcupacaoLista : [
            {"label": "Individual", "value": 1},
            {"label": "Com acompanhante", "value": 2},
            {"label": "Com criança", "value": 3}
        ]
      }
    },
    mounted(){
        this.obterQuartos()
    },
    methods: {
      adicionarPessoa (){

          if(this.validarAdicionarPessoa()){
            this.Pessoas.push(this.PessoasDTO)
            this.PessoasDTO = {}
          }

      },
      excluirPessoa(chave) {
          this.Pessoas.splice(chave, 1)
      },
      limparPessoasDTO() {
          this.PessoasDTO = {}
      },
      validarAdicionarPessoa () {

        this.mensagens = []

        if(this.util.isNullOrEmpty(this.PessoasDTO.nm_pessoa)){
            this.mensagens.push("Nome <i>não preenchido</i>.")
        }

        if(this.util.isNullOrEmpty(this.PessoasDTO.email)){
            this.mensagens.push("E-mail <i>não preenchido</i>.")
        }

        if(this.util.isNullOrEmpty(this.PessoasDTO.dt_nascimento)){
            this.mensagens.push("Data de nascimento <i>não preenchido</i>.")
        }

        if(this.util.isNullOrEmpty(this.PessoasDTO.nu_cpf)){
            this.mensagens.push("CPF <i>não preenchido</i>.")
        }

        if(this.mensagens.length === 0){
            return true
        }else {
            this.validacaoErrorPessoa = true
            this.mensagemTipo = 3
        }

        $("html, body").animate({ scrollTop: 0 }, "slow")

      },
      async obterQuartos(){

            await AXIOS.get(`/ocupacoes/obterListaQuartosDisponiveis/`)
            .then(response => {
                var res = response.data

                for (let index = 0; index < res.length; index++) {
                    let element = res[index]
                    this.quartosLista.push({"label": element.nu_quarto, "value": element.id})
                }
            })

      },
      async adicionarOcupacao () {

        if(this.validarAdicionarOcupacao()){

            $("#preloader").show()

            this.mensagens = []
 
            // Adaptando combos
            this.Ocupacoes.quarto_id    = (this.Combos.quartos !== null && this.Combos.quartos.value !== undefined
                                            ? this.Combos.quartos.value : null)
            this.Ocupacoes.tp_ocupacao  = (this.Combos.tp_ocupacao !== null && this.Combos.tp_ocupacao.value !== undefined
                                            ? this.Combos.tp_ocupacao.value : null)

            try {                
                await AXIOS.put(`/ocupacoes/adicionarOcupacoes/` + this.Ocupacoes.quarto_id, this.Ocupacoes).then(response => {
                    var res = response.data
                    this.salvarPessoas(res)
                })
                swal("Sucesso!", "Ocupação registrada com sucesso.", "success")
                this.registroAdicionado = true
            } catch (e) {
                swal("Error!", "Erro interno na aplicação.", "error")
            }

            $("#preloader").hide()
        }
  
      },
      async salvarPessoas(res) {

            for (var i = 0; i < this.Pessoas.length; i++) {
                await AXIOS.put(`/ocupacoes/adicionarPessoas/` + res.id, this.Pessoas[i])
            }

      },
      validarAdicionarOcupacao () {

        this.mensagens = []

        if(this.util.isNullOrEmpty(this.Combos.quartos)){
            this.mensagens.push("Quarto <i>não preenchido</i>.")
        }

        if(this.util.isNullOrEmpty(this.Ocupacoes.dt_checkin)){
            this.mensagens.push("Checkin <i>não preenchido</i>.")
        }

        if(this.util.isNullOrEmpty(this.Combos.tp_ocupacao)){
            this.mensagens.push("Tipo de hospedagem <i>não preenchido</i>.")
        }

        if(this.util.isNullOrEmpty(this.Ocupacoes.qtd_dias)){
            this.mensagens.push("Dias de estadia <i>não preenchido</i>.")
        }

        if(this.mensagens.length === 0){
            return true
        }else {
            this.validacaoError = true
            this.mensagemTipo = 3
        }

        $("html, body").animate({ scrollTop: 0 }, "slow")

      }
    }
  }
</script>