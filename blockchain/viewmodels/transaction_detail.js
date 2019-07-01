var app = new Vue({
    el: '#app',
    data: {
        address:{},
        addressdata:[{}],
    },
    mounted(){
        console.log('mounted');
        var url = new URL(location.href);
        var object = url.searchParams.get('object')
        this.selectall(object);
    },
    methods:{
        selectall(object){
            this.address = JSON.parse(object);
            this.addressdata[0]=this.address;
            console.log(this.addressdata);
        },
        handleCurrentChange(val){
            console.log(val);
        }
    }
})