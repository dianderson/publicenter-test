<template>
  <q-page>
    <div class="q-pa-md">
      <q-layout
        view="lHh lpr lFf"
        container
        style="height: calc(800px - 90px)"
        class="shadow-2 rounded-borders"
      >
        <q-header bordered class="bg-blue-grey-5">
          <q-toolbar-title align="center">
            Login
          </q-toolbar-title>
        </q-header>

        <q-page-container pading align="center" style="margin-top:40px">
          <div class="q-pa-md" style="max-width: 400px">
            <q-form @submit="onSubmit" @reset="onReset" class="q-gutter-md">
              <q-input
                v-model="userName"
                label="Usuario"
                lazy-rules
                :rules="[
                  val =>
                    (val && val.length > 0) || 'Insira um usuário cadastrado'
                ]"
              />

              <q-input
                v-model="password"
                label="Senha"
                :type="isPwd ? 'password' : 'text'"
                lazy-rules
                :rules="[
                  val => (val && val.length > 0) || 'Insira uma senha válida'
                ]"
              >
                <template v-slot:append>
                  <q-icon
                    :name="isPwd ? 'visibility_off' : 'visibility'"
                    class="cursor-pointer"
                    @click="isPwd = !isPwd"
                  />
                </template>
              </q-input>

              <div class="form-group row">
                <div class="col-md-6">
                  <q-btn
                    label="Acessar"
                    type="submit"
                    class="bg-blue-grey-4"
                    color="width"
                    style="width: 150px"
                  />
                </div>
                <div class="col-md-6">
                  <q-btn
                    label="Reset"
                    type="reset"
                    class="bg-blue-grey-4"
                    color="width"
                    style="width: 150px"
                  />
                </div>
              </div>
            </q-form>
          </div>
          <q-btn class="bg-blue-grey-5" label="Botão" @click="testeRecuperaToken"/>
        </q-page-container>
      </q-layout>
    </div>
  </q-page>
</template>

<script>
import axios from 'axios'

export default {
  data () {
    return {
      userName: '',
      password: '',
      isPwd: true
    }
  },
  mounted () {
  },

  methods: {
    onSubmit () {
      axios.post('http://localhost:8080/auth',
        {
          username: this.userName,
          password: this.password
        }).then(token => {
        console.log(token)
      })
    },
    testeRecuperaToken () {
      console.log(localStorage.getItem('key'))
    },

    onReset () {
      this.userName = null
      this.password = null
    }
  }
}
</script>
