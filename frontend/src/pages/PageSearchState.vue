<template>
  <div class="q-pa-md bg-blue-grey-1" align="center">
    <q-layout view="lHh lpr lFf" container style="width: 98%;height: calc(800px - 85px)"
              class="shadow-2 rounded-borders">
      <q-header bordered class="bg-blue-grey-5">
        <q-toolbar-title align="center">
          Pesquisar estado
        </q-toolbar-title>
      </q-header>

      <q-page-container align="center">
        <q-page padding class="bg-blue-grey-1" style="margin-top: -25px">

          <div class=" row flex-center">
            <q-input v-model="text" label="Nome" style="width: 300px ;margin-inline: 20px"/>
            <q-input v-model="text" label="Sigla" style=" width: 100px;margin-inline: 20px"/>
          </div>

          <div style="margin-top: 10px">
            <q-btn label="Pesquisar" type="submit" class="bg-blue-grey-4" color="white"
                   style="width: 150px;height: 35px;margin: 10px" icon="search" @click="findAllState"/>

            <q-btn label="Limpar" type="reset" class="bg-blue-grey-4" color="white"
                   style="width: 135px;height: 35px;margin: 10px" icon="clear"/>

            <q-btn label="Imprimir" type="submit" class="bg-blue-grey-4" color="white"
                   style="width: 135px;height: 35px;margin: 10px" icon="print"/>
          </div>

          <div class="q-pa-md" style="max-width: 800px">
            <q-table
              class="bg-blue-grey-2"
              :data="rows"
              :columns="columns"
              row-key="name"
              :pagination.sync="pagination"
              hide-pagination
              separator="cell"
            >
              <template v-slot:body="props">
                <q-tr :props="props">
                  <q-td
                    v-for="col in props.cols"
                    :key="col.name"
                    :props="props"
                  >
                    {{ col.value }}
                  </q-td>
                  <q-td class="bg-blue-grey-3">
                    <q-btn flat round dense color="white" icon="search"/>
                    <q-btn flat round dense color="white" icon="update"/>
                    <q-btn flat round dense color="white" icon="delete"/>
                  </q-td>
                </q-tr>
              </template>
            </q-table>
          </div>

          <q-footer elevated class="bg-blue-grey-7">
            <q-pagination
              v-model="pagination.page"
              class="flex-center"
              color="white"
              :max="pagesNumber"
              input-class="text-bold"
              :input="true"
            />
          </q-footer>
        </q-page>
      </q-page-container>
    </q-layout>
  </div>
</template>

<script>

import axios from 'axios'

export default {
  name: 'PageSearchState',
  data () {
    return {
      pagination: {
        sortBy: 'desc',
        descending: false,
        page: 1,
        rowsPerPage: 10
      },
      columns: [
        {
          name: 'id',
          align: 'center',
          label: 'Código',
          field: 'id',
          sortable: true,
          style: 'width: 15%',
        },
        {
          name: 'name',
          align: 'left',
          label: 'Nome',
          field: 'name',
          sortable: true,
          style: 'width: 65%'
        },
        {
          name: 'code',
          align: 'center',
          label: 'Sigla',
          field: 'code',
          sortable: true,
          style: 'width: 20%'
        }
      ],
      rows: []
    }
  },
  mounted () {
  },
  methods: {
    findAllState () {
      axios.get('http://localhost:8080/state').then(response => {
        this.rows = response.data.content
      })
    }
  },
  computed: {
    pagesNumber () {
      return Math.ceil(this.rows.length / this.pagination.rowsPerPage)
    }
  }
}
</script>

<style scoped>

</style>
