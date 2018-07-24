import Vue from 'vue'
import Router from 'vue-router'
Vue.use(Router)


import Signin from '../components/SignIn.vue'
import Signup from '../components/SignUp.vue'
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
      path: '/sign-up',
      component: Signup,
      name: 'signup'
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
