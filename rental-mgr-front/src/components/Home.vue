<template>
  <div>
    <nav-bar></nav-bar>
    <user-bookings></user-bookings>
  </div>
</template>

<script>
import navBar from './Navbar.vue'
import userBookings from './UserBookings.vue'

export default {
  components: {navBar, userBookings},
  data() {
    return {
      user: this.$store.getters.user
    }
  },

}
</script>

<style>
</style>

