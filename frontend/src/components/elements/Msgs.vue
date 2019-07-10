<template>
    <div id="element_msgs">
        <div class="alert alert-dismissable"
            v-bind:class="{
                'alert-danger'  : (mensagemTipo === 3),
                'alert-warning' : (mensagemTipo === 2),
                'alert-success' : (mensagemTipo === 1),
                'alert-info'    : (mensagemTipo === 0),
            }"
        >
            <button type="button" class="close" @click="apagarMensagens">×</button>
            <h2 class="text-white m-t-0">{{ titulo }}</h2>
            <div v-for="valor in mensagens" v-bind:key="valor">
                <p v-html="valor" class="m-b-0"></p>
            </div>
        </div>
    </div>
</template>

<script>
  export default {
    name: 'element_msgs',
    props: {
        mensagemTipo : {type: String},
        mensagens: {type: []}
    },
    data (){
        return {
            titulo: null,
            classCss: null
        }
    },
    mounted(){
        this.init()
    },
    methods: {
        init(){
            if(this.$parent.mensagemTipo === 0){
                this.titulo = "Informação"
            }else if(this.$parent.mensagemTipo === 1){
                this.titulo = "Sucesso"
            }else if(this.$parent.mensagemTipo === 2){
                this.titulo = "Aviso"
            }else if(this.$parent.mensagemTipo === 3){
                this.titulo = "Erro";
            }
        },
        apagarMensagens(){
            this.$parent.mensagens = []
            this.$parent.validacaoError = false
            this.$parent.validacaoErrorPessoa = false
        }
    }
  }
</script>