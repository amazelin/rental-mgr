<template>
  <nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <a class="navbar-brand" href="#">Expand at md</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample04" aria-controls="navbarsExample04" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarsExample04">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Link</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="https://example.com" id="dropdown04" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">{{user.firstName}}</a>
          <div class="dropdown-menu" aria-labelledby="dropdown04">
            <a class="dropdown-item" href="#">Profile</a>
            <button class="dropdown-item" v-on:click.prevent="logout">Logout</button>
          </div>
        </li>
      </ul>

    </div>
  </nav>
</template>

<script>

export default {
  data() {
    return {
      user : {}
    }
  },
  created: function(){
    this.$http.get('http://localhost:8081/users/{id}', {params: {id: this.$store.getters.user.id}, headers: {'Authorization': this.$store.getters.user.token}}, ).then(response => {
      this.user = response.body;
    }, response => {
     // error callback
    });
  },
  methods: {
    logout(){
      this.$store.commit('LOGOUT');
      this.$router.push('index');
    }

  }
}
</script>

<style>
</style>
