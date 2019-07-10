<template>
  <div id="listar_ocupacoes">
    <!-- Page Content -->
    <div id="page-wrapper">
        <div class="container-fluid">
            <div class="row bg-title">
                <!-- .page title -->
                <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                    <h4 class="page-title">Ocupações</h4>
                </div>
                <!-- /.page title -->
                <!-- .breadcrumb -->
                <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
                    <a href="#" target="_blank" class="btn btn-danger pull-right m-l-20 btn-rounded btn-outline hidden-xs hidden-sm waves-effect waves-light">Buy Now</a>
                    <ol class="breadcrumb">
                        <li><a href="#">Início</a></li>
                        <li class="active">Ocupações</li>
                    </ol>
                </div>
                <!-- /.breadcrumb -->
            </div>
            <div class="row m-b-20 text-right">
                <div class="col-lg-12">
                    <router-link to="/ocupacoes/adicionar" class="btn btn-info waves-effect waves-light"><i class="fa fa-plus-circle"></i> Registrar Nova Ocupação</router-link>
                </div>
            </div>
            <!--/row-->

            <div class="panel panel-default">
                <div class="panel-wrapper collapse in">
                    <div class="panel-body">
                        <!--.row-->
                        <div class="row">
                            <div class="col-md-12 col-lg-12 col-sm-12">
                                <div class="row row-in">
                                    <div class="col-lg-6 col-sm-6 row-in-br">
                                        <div class="col-in row">
                                            <div class="col-md-6 col-sm-6 col-xs-6">
                                                <h3 class="text-muted vb">Qtd. de quartos disponíveis</h3>
                                            </div>
                                            <div class="col-md-6 col-sm-6 col-xs-6">
                                                <h3 class="counter text-right m-t-15 text-info">{{Dashboard.qtdDisponiveis}}</h3>
                                            </div>
                                            <div class="col-md-12 col-sm-12 col-xs-12">
                                                <div class="progress">
                                                    <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width: 100%"> <span class="sr-only">40% Complete (success)</span> </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-6 col-sm-6 b-r-none">
                                        <div class="col-in row">
                                            <div class="col-md-6 col-sm-6 col-xs-6">
                                                <h3 class="text-muted vb">Qtd. de quartos ocupados</h3>
                                            </div>
                                            <div class="col-md-6 col-sm-6 col-xs-6">
                                                <h3 class="counter text-right m-t-15 text-success">{{Dashboard.qtdOcupados}}</h3>
                                            </div>
                                            <div class="col-md-12 col-sm-12 col-xs-12">
                                                <div class="progress">
                                                    <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width: 100%"> <span class="sr-only">40% Complete (success)</span> </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--/row-->
                    </div>
                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading">
                    Registros
                    <div class="pull-right">
                        <a href="#" data-perform="panel-collapse"><i class="ti-minus"></i></a>
                    </div>
                </div>
                <div class="panel-wrapper collapse in">
                    <div class="panel-body">
                        <!--.row-->
                        <div class="row">
                            <div class="col-md-5 m-b-20">
                                <label class="control-label col-md-12">Quartos</label>
                                <v-select v-model="Combos.quartos" :options="quartosLista" placeholder="Selecione..." tabindex="1">
                                    <span slot="no-options">Nenhum resultado encontrado.</span>
                                </v-select>
                            </div>
                            <div class="col-md-5">
                                <div class="form-group">
                                    <label class="control-label col-md-12">Nome cliente</label>
                                    <input type="text" class="form-control" v-model="Filtro.nm_pessoa" placeholder="Nome cliente" tabindex="2">
                                </div>
                            </div>
                            <div class="col-md-2">
                                <div class="form-group text-center">
                                    <label class="control-label col-md-12">&nbsp;</label>
                                    <button class="btn btn-info" @click="obterLista('')"><i class="fa fa-search"></i> Buscar</button>
                                </div>
                            </div>
                        </div>
                        <!--/row-->

                        <div class="table-responsive" v-if="lista[0] !== undefined">
                            <table class="table muted-bordered-table table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>
                                            <a href="#" @click.prevent="definirOrdem('nu_quarto')">
                                                <b>Quarto</b>
                                                <span v-html="Sort.ordem_dir === 1 ? 'A-Z' : 'Z-A'" v-if="Sort.ordem === 'nu_quarto'" class="sort"></span>
                                            </a>
                                        </th>
                                        <th class="text-center">
                                            <b>Situação</b>
                                        </th>
                                        <th>
                                            <a href="#" @click.prevent="definirOrdem('dt_checkin')">
                                                <b>Checkin</b>
                                                <span v-html="Sort.ordem_dir === 1 ? 'A-Z' : 'Z-A'" v-if="Sort.ordem === 'dt_checkin'" class="sort"></span>
                                            </a>
                                        </th>
                                        <th>
                                            <a href="#" @click.prevent="definirOrdem('dt_checkout')">
                                                <b>Checkout</b>
                                                <span v-html="Sort.ordem_dir === 1 ? 'A-Z' : 'Z-A'" v-if="Sort.ordem === 'dt_checkout'" class="sort"></span>
                                            </a>
                                        </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr v-for="valor in lista" v-bind:key="valor" :class="{ 'success' : valor.in_ativo, 'danger' : !valor.in_ativo }">
                                        <td>{{valor.quartos.nu_quarto}}</td>
                                        <td class="text-center">
                                            <span class="label label-info" v-if="!valor.in_ativo">INATIVA</span>
                                            <span class="label label-success" v-if="valor.in_ativo">ATIVO</span>
                                        </td>
                                        <td>{{valor.dt_checkin}}</td>
                                        <td>{{valor.dt_checkout}}</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <p v-if="lista[0] === undefined" class="font-bold">Nenhum registro encontrado.</p>
                    </div>
                    <div v-if="lista[0] !== undefined" class="panel-footer" style="overflow: hidden;">
                        <page :pageAtual="pageAtual" :pageTotalRegistros="pageTotalRegistros"></page>
                    </div>
                </div>
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

  // Paginação
  import Page from '../elements/Page.vue'

  // Mask
  import {TheMask} from 'vue-the-mask'

  export default {
    name: 'listar_ocupacoes',
    components: {
        vSelect,
        Page,
        TheMask
    },
    data () {
      return {
        response: [],
        errors: [],
        lista: [],
        pageAtual: 0,
        pageTotalRegistros: 0,
        busca: false,
        quartosLista : [],
        Combos: {
            quartos : null
        },
        Filtro: {
            quarto_id : "",
            nm_pessoa : ""
        },
        Sort: {
            ordem       : "nu_quarto",
            ordem_dir   : 1,
            nu_quarto   : null,
            dt_checkin  : null,
            dt_checkout : null
        },
        Dashboard: {
            qtdDisponiveis : 0,
            qtdOcupados : 0
        }
      }
    },
    async mounted(){
       $("#preloader").show()
       await this.obterLista("")
       await this.obterQuartos()
       await this.obterDashboard()
       $("#preloader").hide()
    },
    methods: {
        async obterQuartos(){

            await AXIOS.get(`/ocupacoes/obterQuartos/`)
            .then(response => {
                var res = response.data

                for (let index = 0; index < res.length; index++) {
                    let element = res[index]
                    this.quartosLista.push({"label": element.nu_quarto, "value": element.id})
                }
            })

        },
        async obterDashboard(){

            await AXIOS.get(`/ocupacoes/obterQtdQuartosDisponiveis/`)
            .then(response => {
                var res = response.data
                this.Dashboard.qtdDisponiveis = res
            })
            await AXIOS.get(`/ocupacoes/obterQtdQuartosOcupados/`)
            .then(response => {
                var res = response.data
                this.Dashboard.qtdOcupados = res
            })

        },
        obterLista(pag) {

            $("#preloader").show()

            this.pageAtual = pag

            // Adaptando combos
            this.Filtro.quarto_id = (this.Combos.quartos !== null && this.Combos.quartos.value !== undefined ? 
                                        this.Combos.quartos.value : "")

            var filtro =
                `?quarto_id=`     + this.Filtro.quarto_id +
                `&nm_pessoa=`     + this.Filtro.nm_pessoa +
                `&ordem=`         + this.Sort.ordem +
                `&ordem_dir=`     + this.Sort.ordem_dir +
                `&pagina=`        + pag

            AXIOS.get(`/ocupacoes/filtro` + filtro)
            .then(response => {
                var res = response.data

                this.lista = res.ocupacoes
                this.pageTotalRegistros  = res.quantidade
            })
            .catch(e => {
                swal("Error!", "Erro interno na aplicação.", "error")
                console.log('Erro ao obter a lista', e)
            })
            .then(function () {
                $("#preloader").hide()
            });

        },
        definirOrdem(referencia){
            this.Sort.ordem = referencia
            this.Sort.ordem_dir = this.Sort.ordem_dir ? 0 : 1
            this.obterLista(this.pageAtual)
        }
    }
  }
</script>