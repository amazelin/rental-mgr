<template>
  <div>
    <h1>Hello! {{user.firstName}} {{user.lastName}}</h1>

    <label>Prénom : <input type="text" v-model="user.firstName"></label>
    <label>Nom :<input type="text" v-model="user.lastName"></label>
    <label>Adresse e-mail :<input type="email" v-model="user.email"></label>
    <label>Mot de passe : <input type="password" v-model="user.password"></label>
    <input type="submit" value="Valider" v-on:click="submit">

    <div>
      <ul>
        <li>
          {{user.firstName}}
          {{user.lastName}}
          {{user.email}}
          {{user.password}}

          {{isValidatedForm}}
          {{callBackStatus}}
        </li>
      </ul>

    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      user: {
        firstName: '',
        lastName: '',
        email: '',
        password: ''
      },
      isValidatedForm : false,
      callBackStatus : 'init'
    }
  },
  methods:{
    submit() {
      this.isValidatedForm = true;
      var resource = this.$resource('http://localhost:8081/users/sign-up');
      resource.save(this.user).then(response => {
        //success callback
        this.callBackStatus = 'success';
      }, response => {
        this.callBackStatus = 'error';
      });
    }
  }
}
</script>
