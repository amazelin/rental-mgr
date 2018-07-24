<template>
  <div class="container">
      <form class="form-signin">
        <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="Email address" v-model="user.login" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" v-model="user.password" placeholder="Password" required>
        <div class="checkbox mb-3">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" v-on:click.prevent="submit">Sign in</button>
        <router-link to="/sign-up">Sign-up</router-link>
        <router-link to="/home">Home</router-link>
        <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
      </form>
    <p>
        login: {{user.login}}
        password : {{user.password}}
    </p>
  </div>
</template>

<script>

export default {
  data() {
    return {
      user: { login:'mazelin.arnaud@gmail.com', password:123 }
    }
  },
  methods:{
//    submit(){
//        var resource = this.$resource('http://localhost:8081/login');
//        resource.save(signIn).then(response => {
//          this.user = response.body;
//        }, response => {
//          this.callBackStatus = 'error';
//        });
    submit: function(event){
    console.log(this.user)
      this.$store.commit('LOGIN', this.user)
      this.$router.push('home')

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
