import Vue from 'vue'
import Router from 'vue-router'
Vue.use(Router)


import Signin from '../components/SignIn.vue'
import Subscribe from '../components/Subscribe.vue'
import Home from '../components/Home.vue'


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
      path: '/home',
      component: Home,
      name: 'home'
    },
    {
      path: '*',
      redirect: '/signin'
    }
  ]
})
