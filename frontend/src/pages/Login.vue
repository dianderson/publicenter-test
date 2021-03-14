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
                    (val && val.length > 0) || 'Insira o usuário cadastrado'
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
        </q-page-container>
      </q-layout>
    </div>
  </q-page>
</template>

<script>
import axios from 'axios'
import Template from 'src/layouts/Template.vue'

export default {
  components: { Template },
  data () {
    return {
      userName: '',
      password: '',
      isPwd: true
    }
  },
  mounted () {
    axios.get('http://localhost:8080/state').then(response => {
      this.info = response.data.bpi
    })
  },

  methods: {
    onSubmit () {
      if (this.accept !== true) {
        this.$q.notify({
          color: 'red-5',
          textColor: 'white',
          icon: 'warning'
        })
      } else {
        this.$q.notify({
          color: 'green-4',
          textColor: 'white',
          icon: 'cloud_done',
          message: 'Submitted'
        })
      }
    },

    onReset () {
      this.userName = null
      this.password = null
    }
  }
}
</script>
