<template>
  <table class="table">
    <thead>
      <tr>
        <th scope="col">#</th>
        <th scope="col">Created</th>
        <th scope="col">Start date</th>
        <th scope="col">End date</th>
        <th scope="col">Status</th>
      </tr>
    </thead>
    <tbody v-for="booking in bookings">
      <tr>
        <th scope="row">{{booking.id}}</th>
        <td>{{booking.createDate}}</td>
        <td>{{booking.startDate}}</td>
        <td>{{booking.endDate}}</td>
        <td>{{booking.status.label}}</td>
      </tr>
    </tbody>
  </table>
</template>

<script>

export default {
  data() {
    return {
      bookings: {}
    }
  },
  created: function(){
    this.$http.get('http://localhost:8081/users/{id}/bookings', {params: {id: this.$store.getters.user.id}, headers: {'Authorization': this.$store.getters.user.token}}, ).then(response => {
      this.bookings = response.body;
    }, response => {
     // error callback
    });
  }

}
</script>

<style>
</style>
