<template>
  <div>
    Hello
  </div>
</template>

<script>

export default {
  data() {
    return {
      user: this.$store.getters.user
    }
  },
  created: function(){
    this.$http.get('http://localhost:8081/users/{id}', {params: {id: this.$store.getters.user.id}, headers: {'Authorization': this.$store.getters.user.token}}, ).then(response => {
      this.user = response.body;
    }, response => {
     // error callback
    });
  }

}
</script>

<style>
</style>
