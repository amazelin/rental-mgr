<template>
  <div id="app">
    <div><router-view></router-view></div>
  </div>
</template>

<script>

  import signup from './components/SignUp.vue'
  import signin from './components/SignIn.vue'
  import home from './components/Home.vue'

  export default {
    name: 'app',
    components:{
      signup,signin,home
    }
  }
</script>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
