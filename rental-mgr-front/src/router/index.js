import Vue from 'vue'
import Router from 'vue-router'

import Signin from '../components/SignIn.vue'
import Subscribe from '../components/Subscribe.vue'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      component: Signin,
      name: 'index'
    },
    {
      path: '/signin',
      component: Signin,
      name: 'signin'
    },
    {
      path: '/subscribe',
      component: Subscribe,
      name: 'subscribe'
    },
    {
      path: '*',
      redirect: '/signin'
    }
  ]
})
