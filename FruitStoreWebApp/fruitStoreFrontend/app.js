const fruit = Vue.defineComponent({
    props: ["name", "picture", "price"],

    methods: {
        addToCart(){
            this.$emit("addItem", {
                name: this.name,
                price: this.price
            })
        }
    },

    template:
        `<div id="product">
        <img v-bind:src="picture"/>
        <h1>\${{price}}</h1>
        <button @click="addToCart">add to cart</button>
        </div>`
})



const shoppingCart = Vue.defineComponent({

    data(){
        return {
            totalPrice: "0.00",
            items: [],
            username: "Not Signed In",
            signInValue: "",
            signUpValue: ""
        }
    },

    methods: {
        checkout(){

            let message = "You purchased the following items:\n";
            for (let item of this.items) {
                message += `${item}\n`;
            }
            message += `Total Price: $${this.totalPrice}`;
            this.checkoutMessage = message;

            // Show alert box
            alert(this.checkoutMessage);

            this.items = []
            this.totalPrice = 0
            this.addItemToCart({name: "", price: "0"})
        },

        async addItemToCart(item){
            this.items.push(item.name);
            this.totalPrice = this.totalPrice/1 + item.price/1

            let shoppingCart = this.items
            
            shoppingCart = "[" + shoppingCart.join(", ") + ", "
            shoppingCart = shoppingCart + `${this.totalPrice}]`

            const username = this.signInValue
            console.log(JSON.stringify({username, shoppingCart}))

            console.log(JSON.stringify({username, shoppingCart}))

            fetch("http://localhost:8080/user/shoppingCart", {
                method: "PUT",
                headers: {"Content-Type":"application/json"},
                body: JSON.stringify({username, shoppingCart})
            }).then(() => console.log("data sent"))
            

        },

        async createNewUser(){

            
            const username = this.signUpValue
            console.log(JSON.stringify({username}))

            fetch("http://localhost:8080/user", {
                method: "POST",
                headers: {"Content-Type":"application/json"},
                body: JSON.stringify({username})
            }).then(() => console.log("data sent"))
        },

       async getUserData(){

        this.items = []
        this.totalPrice = 0
        const username = this.signInValue
        console.log(this.signInValue)
        console.log(JSON.stringify({username}))

        let results;
        await new Promise(resolve => {
            fetch("http://localhost:8080/user/details", {
                method: "PUT",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({username})
            })
            .then(response => response.json())
            .then(data => {
                console.log(data)
                this.username = data.username
                let newList = data.shoppingCart.split(",")

                newList[0] = newList[0].slice[1]
                
                this.totalPrice = newList.pop().slice(0, -1)
                this.items = newList
                
                
                resolve(); // Resolve the promise once results is set
            });
        });

        }
    },

    template:
        `<div id="cart">
            <div id="userBox">
            <div class="signindiv">
                <input id="signup" v-model="signUpValue" placeholder="sign up">
                <button class="userbutton" @click="createNewUser">enter</button>
            </div>
            <div class="signindiv">
            <input id="signin" placeholder="sign in" v-model="signInValue">
            <button class="userbutton" @click="getUserData">enter</button>
            <div/>
                
            </div>
            <h3>{{username}}</h3>
            <div id="selected"></div>
            
            <h4 id="totalPrice">Total Price: \${{totalPrice}}</h4>
            <button id="checkoutButton" @click="checkout">check out</button>
         </div>
         <h3 id="shoppingcarth">Shopping Cart</h3>
         <div v-for="(item, index) in items" :key="index">
            <p id=listItem>{{item}}</p>
         </div>
         </div>`
         
})



const catalog = Vue.defineComponent({

    methods: {
        async addItemToCart(item){
            this.$emit("addItem", item)
        }
    },

    template:
        `
        <div id="catalog">
            <div class="catalogDiv">
                <fruit name="Apple" picture="./pictures/apple.png" price="2.00" @addItem="addItemToCart"></fruit>
                <fruit name="orange" picture="./pictures/orange.png" price="2.50" @addItem="addItemToCart"></fruit>
                <fruit name="banana" picture="./pictures/banana.png" price="2.50" @addItem="addItemToCart"></fruit>
                <fruit name="pear" picture="./pictures/pear.png" price="1.50" @addItem="addItemToCart"></fruit>
                <fruit name="peach" picture="./pictures/peach.png" price="1.75" @addItem="addItemToCart"></fruit>
            </div>

            <div class="catalogDiv">
                <fruit name="apricot" picture="./pictures/apricot.png" price="1.50" @addItem="addItemToCart"></fruit>
                <fruit name="grapes" picture="./pictures/grape.png" price="2.25" @addItem="addItemToCart"></fruit>
                <fruit name="strawberry" picture="./pictures/strawberry.png" price="0.75" @addItem="addItemToCart"></fruit>
                <fruit name="blackberry" picture="./pictures/blackberry.png" price="0.50" @addItem="addItemToCart"></fruit>
                <fruit name="blueberry" picture="./pictures/blueberry.png" price="0.50" @addItem="addItemToCart"></fruit>
            </div>

            <div class="catalogDiv">
                <fruit name="raspberry" picture="./pictures/raspberry.png" price="0.50" @addItem="addItemToCart"></fruit>
                <fruit name="cherry" picture="./pictures/cherry.png" price="0.75" @addItem="addItemToCart"></fruit>
                <fruit name="watermelon" picture="./pictures/watermelon.png" price="6.00" @addItem="addItemToCart"></fruit>
                <fruit name="cantelope" picture="./pictures/cantelope.png" price="4.50" @addItem="addItemToCart"></fruit>
                <fruit name="clementine" picture="./pictures/clementine.png" price="1.50" @addItem="addItemToCart"></fruit>
            </div>

            <div class="catalogDiv">
                <fruit name="lemon" picture="./pictures/lemon.png" price="2.00" @addItem="addItemToCart"></fruit>
                <fruit name="grapefruit" picture="./pictures/grapefruit.png" price="3.00" @addItem="addItemToCart"></fruit>
                <fruit name="pomegranate" picture="./pictures/pomegranate.png" price="3.50" @addItem="addItemToCart"></fruit>
                <fruit name="pineapple" picture="./pictures/pineapple.png" price="4.00" @addItem="addItemToCart"></fruit>
                <fruit name="starfruit" picture="./pictures/starfruitpic.png" price="3.75" @addItem="addItemToCart"></fruit>
            </div>
        </div>
        `,
    components: {

        "fruit": fruit,

    }
})

const structure = Vue.defineComponent({

    methods: {
        addItemToCart(item){
            this.$refs.shoppingCart.addItemToCart(item)

        }
    },

    template: 
    `
    <div id=structureOuter>
    <div id="banner"><h1>Tree Toop</h1></div>
        <div id="structureInner">
            <catalog v-on:addItem="addItemToCart"></catalog>
            <shoppingCart ref="shoppingCart"></shoppingCart>
        </div>
    </div>
    `,
    components: {

        "catalog": catalog,
        "shoppingCart": shoppingCart,

    }
    
})


const app = Vue.createApp({
    
    components: {
        
        "structure": structure,     
    }

})

app.mount("#app")