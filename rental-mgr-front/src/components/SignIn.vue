<template>
  <div class="container">
      <form class="form-signin">
        <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="Email address" v-model="loginForm.login" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" v-model="loginForm.password" placeholder="Password" required>
        <div class="checkbox mb-3">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" v-on:click.prevent="signin">Sign in</button>
        <router-link to="/sign-up">Sign-up</router-link>
        <router-link to="/home">Home</router-link>
        <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
      </form>
  </div>
</template>

<script>

export default {
  data() {
    return {
      loginForm: { login:'mazelin.arnaud@gmail.com', password:123 }
    }
  },
  methods:{
    signin: function(event){
      this.$http.post('http://localhost:8081/login', {login: this.loginForm.login, password: this.loginForm.password}).then(response => {
         var user = this.loginForm;
         user.token = response.headers.get('Authorization');
         user.id = response.headers.get('X-user-id');
         this.$store.commit('LOGIN', user)
         this.$router.push('home')
       }, response => {
         // error callback
       });
    }
  }
}
</script>

<style>
 .form-signin {
   width: 100%;
   max-width: 330px;
   padding: 15px;
   margin: 0 auto;
 }
 .form-signin .checkbox {
   font-weight: 400;
 }
 .form-signin .form-control {
   position: relative;
   box-sizing: border-box;
   height: auto;
   padding: 10px;
   font-size: 16px;
 }
 .form-signin .form-control:focus {
   z-index: 2;
 }
 .form-signin input[type="email"] {
   margin-bottom: -1px;
   border-bottom-right-radius: 0;
   border-bottom-left-radius: 0;
 }
 .form-signin input[type="password"] {
   margin-bottom: 10px;
   border-top-left-radius: 0;
   border-top-right-radius: 0;
 }
</style>
