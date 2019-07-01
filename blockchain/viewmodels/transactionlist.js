var app = new Vue({
    el: '#app',
    data: {
        transactiondata:[],
    },
    mounted(){
        console.log('mounted');
        this.transactionlist();
    },
    methods:{
        transactionlist(){
            axios.get('/temp/transactionlist', {
                params: {
                  
                }
              })
              .then(function (response) {
                console.log(response);
                app.transactiondata=response.data;
              })
              .catch(function (error) {
                console.log(error);
              })
        },
        handleCurrentChange(val){
            console.log(val)
        }
    }
})