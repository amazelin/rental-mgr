<template>
  <div class="container">
    <form class="form-signin">
      <h2 class="form-signin-heading">Please sign in</h2>
      <label for="inputEmail" class="sr-only">Email address</label>
      <input type="email" id="inputEmail" class="form-control" placeholder="Email address" v-model="user.login" required autofocus>
      <label for="inputPassword" class="sr-only" v-model="user.password" required>Password</label>
      <input type="password" id="inputPassword" class="form-control" placeholder="Password" v-model="passwordCheck" required>
      <div class="checkbox">
        <label>
          <input type="checkbox" value="remember-me"> Remember me
        </label>
        <router-link to="/subscribe">Subscribe</router-link>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit" v-on:click="submit">Sign in</button>
    </form>
    <p>
        id: {{user.id}}
        firstName: {{user.firstName}}
        lastName : {{user.lastName}}



    </p>
  </div>
</template>

<script>
export default {
  data() {
    return {
      signIn: {
        login: '',
        password: '',
        passwordCheck: ''
      },
      user: ''
    }
  },
  methods:{
    submit(){
        var resource = this.$resource('http://localhost:8081/login');
        resource.save(signIn).then(response => {
          this.user = response.body;
        }, response => {
          this.callBackStatus = 'error';
        });
    }
  }
}
</script>

<style>

  body {
    padding-top: 40px;
    padding-bottom: 40px;
    background-color: #eee;
  }

  .form-signin {
    max-width: 330px;
    padding: 15px;
    margin: 0 auto;
  }
  .form-signin .form-signin-heading,
  .form-signin .checkbox {
    margin-bottom: 10px;
  }
  .form-signin .checkbox {
    font-weight: normal;
  }
  .form-signin .form-control {
    position: relative;
    height: auto;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
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
