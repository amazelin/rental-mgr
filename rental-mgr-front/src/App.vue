<template>
  <div id="app">
    <div><router-view></router-view></div>
  </div>
</template>

<script>

  import subscribe from './components/Subscribe.vue'
  import signin from './components/SignIn.vue'
  import home from './components/Home.vue'

  export default {
    name: 'app',
    components:{
      subscribe,signin,home
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
