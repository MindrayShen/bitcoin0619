var app = new Vue({
    el: '#app',
    data: {
        blocklist:[],
        time:'',
        longtime:'',

    },
    mounted(){
        console.log("mounted");
        this.blockList();
    },
    methods:{
        blockList(){
            axios.get('/temp/blocklist', {
                params: {
                  
                }
              })
              .then(function (response) {
                console.log(response);
                app.blocklist=response.data;
                this.longtime = response.data.time;
                app.time = new Date(longtime);

              })
              .catch(function (error) {
                console.log(error);
              })
        },
        handleCurrentChange(val){
            console.log(val);
        },
        preblock(){
          console.log("preblock"+longtime);
          axios.get('/temp/preblock', {
            params: {
              time:longtime,
            }
          })
          .then(function (response) {
            console.log(response);
            app.blocklist=response.data;
            this.longtime = response.data.time;
            app.time = new Date(longtime);

          })
          .catch(function (error) {
            console.log(error);
          })
        },
        nextblock(){
          console.log("nextblock"+longtime);
          axios.get('/temp/nextblock', {
            params: {
              time:longtime,
            }
          })
          .then(function (response) {
            console.log(response);
            app.blocklist=response.data;
            this.longtime = response.data.time;
            app.time = new Date(longtime);

          })
          .catch(function (error) {
            console.log(error);
          })
        }
    }
})