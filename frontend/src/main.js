import Vue from 'vue'
import App from './components/App.vue'
import router from './router'
import store from './store'

import vueDirectiveTooltip from 'vue-directive-tooltip';
import 'vue-directive-tooltip/css/index.css';
Vue.use(vueDirectiveTooltip)

Vue.config.productionTip = false

new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app')