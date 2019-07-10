<template>
  <div id="page" class="pull-right">
    <div class="btn-group">
        <span v-for="n in totalDePaginas" :key="n">
          <button
              v-html="n"
              class="btn btn-default btn-outline waves-effect"
              v-bind:class="{'active':((pageAtual + 1) === n)}"
              @click="definirPagina(n)">
          </button>
        </span>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'page',
    props: {
        pageAtual: { required: true },
        pageTotalRegistros: { required: true }
    },
    data () {
      return {
        response: [],
        totalDePaginas: 0
      }
    },
    mounted(){
        this.setTotalDePaginas()
    },
    methods: {
      setTotalDePaginas(){
        this.totalDePaginas = Math.ceil((this.$parent.pageTotalRegistros / 10))
      },
      definirPagina(n){
        this.$parent.obterLista((n-1))
      }
    }
  }
</script>