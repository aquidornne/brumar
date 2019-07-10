<template>
    <!-- Top Menu -->
    <nav id="navbar" class="navbar navbar-default navbar-static-top m-b-0">
        <div class="navbar-header">
            <!-- Icone para mobile -->
            <a class="navbar-toggle hidden-sm hidden-md hidden-lg" href="javascript:void(0)" data-toggle="collapse" data-target=".navbar-collapse"><i class="ti-menu"></i></a>
            <!-- Logo -->
            <div class="top-left-part">
                <router-link to="/">
                    <!-- Logo -->
                    <span><img src="@/assets/img/logo_2.png" style="max-height: 31px;" class="logo-top" alt="home" /></span>
                </router-link>
            </div>
            <!-- /Logo -->
            <!-- Título Sistema -->
            <ul class="nav navbar-top-links navbar-left hidden-xs active">
                <li><a href="javascript:void(0)" class="open-close hidden-xs waves-effect waves-light"><i class="icon-arrow-left-circle ti-menu"></i></a></li>
                <li class="p-t-10 p-l-20 hidden-xs">
                    <h4 class="text-white text-semibold"><span>SISTEMA GESTÃO HOTEL BLUMAR</span></h4>
                </li>
            </ul>
            <!-- /Título Sistema -->
            <ul class="nav navbar-top-links navbar-right pull-right">
                <!-- .Usuários dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle profile-pic" data-toggle="dropdown" href="#"> <img src="./../../assets/plugins/images/users/varun.jpg" alt="user-img" width="36" class="img-circle"><b class="hidden-xs">Alan</b> </a>
                    <ul class="dropdown-menu dropdown-user animated flipInY">
                        <li><a href="#" v-if="isAuthenticated" @click="logout"><i class="fa fa-power-off"></i> Sair</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <!-- /.navbar-header -->
        <!-- /.navbar-top-links -->
        <!-- /.navbar-static-side -->
    </nav>
    <!-- End Top Navigation -->
</template>

<script>
  import { mapGetters } from 'vuex'
  import { AUTH_LOGOUT } from '@/store/actions/auth'

  export default {
    name: 'element_navbar',
    methods: {
      logout: function () {
        this.$store.dispatch(AUTH_LOGOUT).then(() => this.$router.push('/login'))
      }
    },
    computed: {
      ...mapGetters(['isAuthenticated'])
    }
  }
</script>