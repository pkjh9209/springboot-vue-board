<template>
    <div>
        <button type="button" v-on:click="createBoard()">글쓰기</button>
        <div class="navWrap col-4">
            <a>Main List Page</a>
            <a>Commons Menu</a>
        </div>
        <div class="contentList col-8">
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                    <th scope="col">번호</th>
                    <th scope="col">글제목</th>
                    <th scope="col">이름</th>
                    <th scope="col">날짜</th>
                    </tr>
                </thead>
                <tbody>
                    <tr :key="index" v-for="(result, index) in result" v-on:click="detail(result.NUM)">
                        <td>{{result.NUM}}</td>
                        <td>{{result.TITLE}}</td>
                        <td>{{result.NAME}}</td>
                        <td>{{moment(result.REGDATE).format('YYYY-MM-DD')}}</td>
                        <td>{{result.NAME}}</td>
                    </tr>   
                </tbody>
            </table>
        </div>
        <div>
            <a>${page}</a>
        </div>
    </div>
</template>
<script>
export default {
    
    name : 'Read',
    data() {
        return {
            result:[]
        }
    },
    methods : {
        detail(num){
            this.$router.push({
                name: 'Detail',
                params: {
                    num: num
                }
            })
        },
        getData(){
            this.$http.get('http://localhost:8080/view/')
            .then((response) => {
                this.result = response.data
               })					
        },
        createBoard(){
            this.$router.push({
                name: 'Create'
            })
        }
},
    mounted(){
        this.getData()
    }
}
</script>