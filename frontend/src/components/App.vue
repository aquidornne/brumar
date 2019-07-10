<template>
  <div id="app">
    <!-- Font-Awesome -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://fortawesome.github.io/Font-Awesome/assets/font-awesome/css/font-awesome.css">
    <!-- Simple line icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.4.1/css/simple-line-icons.css">

    <!-- Preloader -->
    <div id="preloader" class="preloader">
        <div class="cssload-speeding-wheel"></div>
    </div>

    <div id="wapper">
      <navbar v-if="isAuthenticated"></navbar>
      <sidebar v-if="isAuthenticated"></sidebar>
      <router-view></router-view>
    </div>
    <footer class="footer text-center" v-if="isAuthenticated">2019 Alan Quidornne de Souza</footer>
  </div>
</template>

<script>

window.$ = require('jquery')
window.JQuery = require('jquery')

import navbar from '@/components/elements/Navbar';
import sidebar from '@/components/elements/Sidebar';

require('@/assets/plugins/bower_components/jquery/dist/jquery.min.js')
require('@/assets/bootstrap/dist/js/bootstrap.min.js')
require('@/assets/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.js')
require('@/assets/plugins/bower_components/sweetalert/sweetalert.min.js')
require('@/assets/js/jquery.slimscroll.js')
require('@/assets/js/custom.min.js')
require('@/assets/js/cbpFWTabs.js')

import { mapGetters } from 'vuex'
import { AUTH_LOGOUT } from '@/store/actions/auth'
import { USER_REQUEST } from '@/store/actions/user'

export default {
  name: 'app',
  components: {
      navbar,
      sidebar
  },
  created: function () {
    if (this.$store.getters.isAuthenticated) {
      this.$store.dispatch(USER_REQUEST)
    }
  },
  computed: {
    ...mapGetters(['getProfile', 'isAuthenticated']),
  }
}
</script>

<style>
  /* Bootstrap Core CSS */
  @import './../assets/bootstrap/dist/css/bootstrap.min.css';
  /* Menu CSS */
  @import './../assets/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css';
  /* Animation CSS */
  @import './../assets/css/animate.css';
  /* Custom */
  @import './../assets/css/style.css';
  /* Css principal do tema */
  @import './../assets/css/theme.css';
  /* Customizar Bootstrap */
  @import './../assets/css/custom.css';
  @import './../assets/fonts/themify-icons/themify-icons.css';
  @import './../assets/plugins/bower_components/sweetalert/sweetalert.css';
</style>