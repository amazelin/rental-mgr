import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({

  state: {
    isLoggedIn: !!localStorage.getItem("token")
  },
  mutations: {
    LOGIN (state) {
      state.pending = true
    },
    LOGIN_SUCCESS (state) {
      state.isLoggedIn = true
      state.pending = false
    },
    LOGOUT (state) {
      state.isLoggedIn = false
    }
  },
  getters: {
    logged: (state) => state.isLoggedIn
  },
  actions: {
    login({commit}) {
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
