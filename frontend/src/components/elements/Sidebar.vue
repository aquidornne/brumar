<template>
    <!-- Left navbar-header -->
    <div id="sidebar" class="navbar-default sidebar" role="navigation">
        <div class="sidebar-nav navbar-collapse">
            <!-- Menu -->
            <ul class="nav" id="side-menu">
                <li>
                    <router-link to="/ocupacoes/" class="waves-effect">
                        <i class="linea-icon linea-basic fa-fw" data-icon="v"></i>
                        <span class="hide-menu">
                            Ocupações
                        </span>
                    </router-link>
                </li>
            </ul>
        </div>
    </div>
    <!-- Left navbar-header end -->
</template>

<script>
  export default {
    name: 'element_sidebar',
    data(){
        return {
            usuarioLogado: JSON.parse(localStorage.getItem('usuarioLogado'))
        }
    },
    mounted(){
    }
  }
</script>