import Vue from 'vue'
import Router from 'vue-router'

import Login from '@/components/login'
import store from '@/store'

const ifNotAuthenticated = (to, from, next) => {
  if (!store.getters.isAuthenticated) {
    next()
    return
  }
  next('/')
}

const ifAuthenticated = (to, from, next) => {
  if (store.getters.isAuthenticated) {
    next()
    return
  }
  next('/login/')
}

import Ocupacoes from '@/components/ocupacoes/index'
import CadastrarOcupacao from '@/components/ocupacoes/adicionar'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/login/',
      name: 'Login',
      component: Login,
      beforeEnter: ifNotAuthenticated
    },
    {
      path: '/',
      name: 'Index',
      component: Ocupacoes,
      beforeEnter: ifAuthenticated
    },
    {
      path: '/ocupacoes/',
      name: 'Ocupacoes',
      component: Ocupacoes,
      beforeEnter: ifAuthenticated
    },
    {
      path: '/ocupacoes/adicionar',
      name: 'CadastrarOcupacao',
      component: CadastrarOcupacao,
      beforeEnter: ifAuthenticated
    }
  ],
  mode: `history`
})
