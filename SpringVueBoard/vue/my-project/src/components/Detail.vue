<template>
    <div>
        <div>{{result.TITLE}}</div>
        <div>{{result.NAME}}</div>
        <div>{{result.CONTENT}}</div>
        <button type="button" v-on:click="updateData(result)">수정</button>
        <button type="button" v-on:click="deleteData(result.NUM)">삭제</button>
    </div>
</template>
<script>
export default {
    name : 'Detail',
    data(){
        return{
            result: []
        }
    },
    methods : {
        getDetailList(){
            var num = this.$route.params.num;
            this.$http.get('http://localhost:8080/detail/'+num+'')
            .then((response) => {
			    this.result = response.data
            }) 
        },
        updateData(result){
            this.$router.push({
                name: 'Create',
                params:{
                    result : result,
                    num : result.NUM
                }
            })
        },
        deleteData(num){
            var num = this.$route.params.num;
            this.$http.get('http://localhost:8080/delete/'+num+'')
            .then((response) => {
                this.result = response.data
            })
            this.$router.push({
                path:'/'
            })
        }
    },
    mounted(){
  		this.getDetailList()
    } 
}
</script>