import Vue from 'vue'
import Vuex from 'vuex'
import VueResource from 'vue-resource'
import App from './App'

import router from './router'
import store from './store'

Vue.use(VueResource)



new Vue({
  store,
  el: '#app',
  router,
  render: h => h(App)
})
