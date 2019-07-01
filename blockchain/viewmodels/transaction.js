var app = new Vue({
    el: '#app',
    data: {
        transaction:{},
        transactiondata:[{}],
    },
    mounted(){
        console.log('mounted');
        var url = new URL(location.href);
        var object = url.searchParams.get('object')
        this.selectall(object);
    },
    methods:{
        selectall(object){
            this.transaction = JSON.parse(object);
            this.transactiondata[0]=this.transaction;
            console.log(this.transactiondata);
        },
        handleCurrentChange(val){
            console.log(val);
        }
    }
})