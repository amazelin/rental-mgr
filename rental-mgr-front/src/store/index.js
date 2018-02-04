import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({

  state: {
    isLoggedIn: !!localStorage.getItem("token"),
    user: { login:"toto", password: '456'}
  },

  mutations: {
    LOGIN (state, user) {
      state.pending = true
      state.user = user
    },
    LOGIN_SUCCESS (state) {
      state.isLoggedIn = true
      state.pending = false
    },
    LOGOUT (state) {
      state.isLoggedIn = false
      state.user = {}
    }
  },
  getters: {
    logged: (state) => state.isLoggedIn,
    user: (state) => state.user
  },
  actions: {
    login({commit}, user) {
      commit(LOGIN)
      return new Promise(resolve => {
        setTimeOut(() => {
          localStorage.setItem("token", "JWT")
          commit(LOGIN_SUCCESS)
          resolve()
        }, 1000)
      })
    },
    logout({commit}){
      localStorage.removeItem("token")
      commit(LOGOUT)
    }
  }
 })
