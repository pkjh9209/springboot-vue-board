<template>
    <div>
        <input type="hidden" v-model="list.num" name="num"/>
        <input v-model="list.name" placeholder="글쓴이"/>
        <input v-model="list.title" placeholder="제목"/>
        <textarea v-model="list.content" placeholder="내용"/>
        <button @click="list.num !== undefined ? updateResult(list) : createResult()">{{list.num !== undefined ? '수정' : '작성'}}</button>
    </div>    
</template>
<script>
    export default {
        name: 'Create',
        data(){
            var result = this.$route.params.result;
            var num = this.$route.params.num;
            return{
                list:{
                    num: num ,
                    name: result !== undefined ? result.NAME : '',
                    title: result !== undefined ? result.TITLE : '',
                    content: result !== undefined ? result.CONTENT : ''
                }
            }
        },
        methods:{
            createResult(){
                this.$http.post('http://localhost:8080/insert/',this.list)
                .then((response) => {
                    console.log(response)
                    this.result = response.data
                }) 

                this.$router.push({
                    path:'/'
                })
            },
            updateResult(){
                this.$http.post('http://localhost:8080/update/',this.list)
                .then((response) => {
                    this.result = response.data
                })            
                this.$router.push({
                    path:'/'
                }) 
            }
        }
    }
</script>