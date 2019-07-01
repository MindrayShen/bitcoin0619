var app = new Vue({
    el: '#app',
    data: {
        input:'',
        activeName:'first',
        blockdata:[],
        transactiondata:[],
    },
    mounted(){
        console.log('mounted')
        this.block();
        this.transaction();
    },
    methods:{
        handleClick(tab, event){
            console.log(tab, event)
        },
        handleCurrentChangeblock(val){
            console.log(val)
            this.selectblockhash(val.blockhash);

        },
        handleCurrentChangetx(val){
            console.log(val)
            this.selecttransactionhash(val.txhash);
        },
        block(){
            axios.get('/temp/block', {
                params: {
                    
                }
                })
                .then(function (response) {
                    console.log(response);
                    app.blockdata=response.data;
                })
                .catch(function (error) {
                console.log(error);
                })
        },
        transaction(){
            axios.get('/temp/transaction', {
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
        blockclick(){
            console.log("blocklist click");
            location.href="blocklist.html";
        },
        transactionclick(){
           console.log("transactionlist click");
           location.href="transactionlist.html";
        },
        selectblockhash(blockhash){
            axios.get('/temp/sreach', {
                params: {
                    sreach:blockhash,
                    
                }
              })
              .then(function (response) {
                  location.href=response.data.url+JSON.stringify(response.data.object);
                  console.log(response);

              })
              .catch(function (error) {
                console.log(error);
              })
        },
        selecttransactionhash(transactionhash){
            axios.get('/temp/sreach', {
                params: {
                    sreach:transactionhash,
                    
                }
              })
              .then(function (response) {
                  location.href=response.data.url+JSON.stringify(response.data.object);
                  console.log(response);

              })
              .catch(function (error) {
                console.log(error);
              })
        },
        selectinput(){
            axios.get('/temp/sreach', {
                params: {
                    sreach:this.input,
                    
                }
              })
              .then(function (response) {
                  if(response.data!=null&&response.data!=''){
                    location.href=response.data.url+JSON.stringify(response.data.object);
                    console.log(response);
                  }else{
                      alert("输入有误");
                  }

              })
              .catch(function (error) {
                console.log(error);
              })
        }
    }
})