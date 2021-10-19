import { http } from './config'

export default {

    listar:() => {
        return http.get('alunos')
    },

    salvar:(aluno) => {
        return http.post('aluno', aluno)
    },

    atualizar:(aluno) => {
        return http.put('aluno', aluno)
    },

    apagar:(aluno) => {
        return http.delete('aluno', aluno)
    },

    upload:(foto) => {
        return http.post('fotos', foto, {
            headers: {
                'Content-type': 'multipart/form-data'
            }
        })
    }

}