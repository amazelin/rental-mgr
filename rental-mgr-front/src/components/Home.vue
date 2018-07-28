<template>
  <div>
    <nav-bar></nav-bar>
  </div>
</template>

<script>
import navBar from './Navbar.vue'

export default {
  components: {navBar},
  data() {
    return {
      user: this.$store.getters.user
    }
  },

}
</script>

<style>
</style>

