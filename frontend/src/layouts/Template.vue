<template>
  <div class="q-pa-md">
    <q-layout
      view="lHh Lpr lff"
      container
      style="min-height: 800px"
      class="shadow-2 rounded-borders"
    >
      <q-header elevated class="bg-blue-grey-7">
        <q-toolbar>
          <q-btn
            flat
            @click="drawer = !drawer"
            round
            dense
            size="20px"
            color="blue"
            icon="menu"
          />
          <q-toolbar-title align="right">Publicenter Sistemas</q-toolbar-title>
          <q-btn
            flat
            round
            dense
            size="20px"
            color="red"
            icon="directions"
            @click="logout"
          />
        </q-toolbar>
      </q-header>

      <q-drawer
        v-model="drawer"
        show-if-above
        :width="200"
        :breakpoint="400"
        bordered
        content-class="bg-blue-grey-5"
      >
        <q-img
          class="absolute-top bg-blue-grey-7"
          style="height: 140px; border-bottom: 1px solid #ddd"
        >
          <div class="absolute-bottom bg-transparent">
            <q-avatar size="56px" class="q-mb-sm">
              <img src="https://cdn.quasar.dev/img/boy-avatar.png"/>
            </q-avatar>
            <div class="text-weight-bold">Dianderson Mendonça</div>
            <div>Usuario: Master</div>
          </div>
        </q-img>

        <q-scroll-area style="height: calc(100% - 130px); margin-top: 130px">
          <q-list padding class="menu-list">
            <q-item active clickable v-ripple style="border: 1px solid #ddd">
              <q-item-section>
                <q-btn-dropdown
                  flat
                  active
                  clickable
                  v-ripple
                  label="Estado"
                  align="left"
                  style="font-size: initial;font-weight: bold;color:white"
                >
                  <q-list class="bg-blue-grey-4" style="font-weight: bold">
                    <q-item
                      active
                      clickable
                      v-close-popup
                      @click="pageSearchState"
                    >
                      <q-item-section style="color:white">
                        <q-item-label>Pesquisar</q-item-label>
                      </q-item-section>
                    </q-item>

                    <q-item
                      active
                      clickable
                      v-close-popup
                      @click="pageCreateState"
                    >
                      <q-item-section style="color:white">
                        <q-item-label>Cadastrar</q-item-label>
                      </q-item-section>
                    </q-item>
                  </q-list>
                </q-btn-dropdown>
              </q-item-section>
            </q-item>

            <q-item active clickable v-ripple style="border: 1px solid #ddd">
              <q-item-section>
                <q-btn-dropdown
                  flat
                  active
                  clickable
                  v-ripple
                  label="Cidade"
                  align="left"
                  style="font-size: initial;font-weight: bold;color:white"
                >
                  <q-list class="bg-blue-grey-4" style="font-weight: bold">
                    <q-item
                      active
                      clickable
                      v-close-popup
                      @click="pageSearchCity"
                    >
                      <q-item-section style="color:white">
                        <q-item-label>Pesquisar</q-item-label>
                      </q-item-section>
                    </q-item>

                    <q-item
                      active
                      clickable
                      v-close-popup
                      @click="pageCreateCity"
                    >
                      <q-item-section style="color:white">
                        <q-item-label>Cadastrar</q-item-label>
                      </q-item-section>
                    </q-item>
                  </q-list>
                </q-btn-dropdown>
              </q-item-section>
            </q-item>
          </q-list>
        </q-scroll-area>
      </q-drawer>

      <q-page-container>
        <router-view/>
      </q-page-container>
    </q-layout>
  </div>
</template>

<script>
export default {
  data () {
    return {
      drawer: false
    }
  },
  mounted () {

  },
  methods: {
    logout () {
    },
    pageSearchState () {
      this.$router.push('/state')
    },
    pageCreateState () {
    },
    pageSearchCity () {
    },
    pageCreateCity () {
    }
  }
}
</script>
