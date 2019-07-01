var app = new Vue({
    el: '#app',
    data: {
        block:{},
        blockdata:[{}],
    },
    mounted(){
        console.log('mounted');
        var url = new URL(location.href);
        var object = url.searchParams.get('object')
        this.selectall(object);
    },
    methods:{
        selectall(object){
            this.block = JSON.parse(object);
            this.blockdata[0]=this.block;
            console.log(this.blockdata);
        },
        handleCurrentChange(val){
            console.log(val);
        }
    }
})