<template>
  <div class="Cadastro" id="app">

    <nav>
      <div class="nav-wrapper blue darken-1">
        <a href="#" class="brand-logo center">Cadastrar Aluno</a>
      </div>
    </nav>

    <div class="container">
     
      <form @submit.prevent="salvar">

        <div class="row">

          <div class="col s12">
            <label>Nome</label>
            <input type="text" placeholder="Nome" v-model="aluno.nome">
          </div>

          <div class="col s12">
            <label>Logradouro</label>
            <input type="text" placeholder="Rua x" v-model="aluno.logradouro">
          </div>

          <div class="col s2">
            <label>Número</label>
            <input type="text" placeholder="Número" v-model="aluno.numero">
          </div>

          <div class="col s7">
            <label>Bairro</label>
            <input type="text" placeholder="Bairro" v-model="aluno.bairro">
          </div>

          <div class="col s3">
            <label>Complemento</label>
            <input type="text" placeholder="Casa/Apt 000" v-model="aluno.complemento">
          </div>

          <div class="col s4">
            <label>Cep</label>
            <input type="text" placeholder="00000-000" v-model="aluno.cep">
          </div>

          <div class="col s4">
            <label>Cidade</label>
            <input type="text" placeholder="Lavras" v-model="aluno.cidade">
          </div>

          <div class="col s4">
            <label>Estado</label>
            <input type="text" placeholder="Minas Gerais" v-model="aluno.estado">
          </div>

          <div class="col s1">
            <button class="waves-effect waves-light btn-small">Salvar
              <i class="material-icons left">save</i></button>
          </div>
        
        </div>

      </form>

      <form>

      <div class="row">
        <div class="file-field input-field col s12">
          <div class="waves-effect waves-light btn-small blue">
            <span>Selecionar Imagem</span>
            <input type="file" @change="onFileSelected"> 
          </div>
        </div>

        <div class="col s12">
          <button @click="onUpload" class="waves-effect waves-light btn-small blue">Upload
            <i class="material-icons left">add_a_photo</i></button>
        </div>
      </div>

      </form>

      <table>

        <thead>

          <tr>
            <th>NOME</th>
            <th>LOGRADOURO</th>
            <th>NÚMERO</th>
            <th>BAIRRO</th>
            <th>COMPLEMENTO</th>
            <th>CEP</th>
            <th>CIDADE</th>
            <th>ESTADO</th>
            <th>OPÇÕES</th>
          </tr>

        </thead>

        <tbody>

          <tr v-for="aluno of alunos" :key="aluno.id">

            <td>{{aluno.nome}}</td>
            <td>{{aluno.logradouro}}</td>
            <td>{{aluno.numero}}</td>
            <td>{{aluno.bairro}}</td>
            <td>{{aluno.complemento}}</td>
            <td>{{aluno.cep}}</td>
            <td>{{aluno.cidade}}</td>
            <td>{{aluno.estado}}</td>
            <td>
              <button @click='editar(aluno)' class="waves-effect btn-small blue darken-1"><i class="material-icons">create</i></button>
              <button @click='remover(aluno)' class="waves-effect btn-small red darken-1"><i class="material-icons">delete_sweep</i></button>
            </td>

          </tr>

        </tbody>
      
      </table>

    </div>

  </div>
</template>

<script>

import Aluno from '../services/alunos'
import Foto from '../services/alunos'

export default {

  data(){
    return {
      aluno: {
        id: '',
        nome: '',
        logradouro: '',
        numero: '',
        bairro: '',
        complemento: '',
        cep: '',
        cidade: '',
        estado: ''
      },
      alunos: [],
      selectedFile: null,
    }
  },

  mounted(){  
    this.listar()
  },

  methods:{

    onFileSelected(event) {
      this.selectedFile = event.target.files[0]
    },

    onUpload() {
      var foto = new FormData();
      foto.append('foto', this.selectedFile, this.selectedFile.name)
      Foto.upload(foto).then(resposta => {
        console.log(resposta)
      })
      
    },

    

    listar(){
      Aluno.listar().then(resposta => {
        this.alunos = resposta.data
      })
    },

    salvar(){

      if(!this.aluno.id){
        // eslint-disable-next-line no-unused-vars
        Aluno.salvar(this.aluno).then(resposta => {
          this.aluno = {}
          alert('Salvo com sucesso!')
          this.listar()
        })
      }else{
        // eslint-disable-next-line no-unused-vars
        Aluno.atualizar(this.aluno).then(resposta => {
          this.aluno = {}
          alert('Atualizado com sucesso!')
          this.listar()
        })
      }

      
    },

    editar(aluno){
      this.aluno = aluno
    },

    remover(aluno){
      if(confirm('Deseja excluir o cadastro?')){
        // eslint-disable-next-line no-unused-vars
        Aluno.apagar(aluno).then(resposta =>{
          this.listar()
        })
      }
      
    }

  }

}

</script>

<style>

</style>
