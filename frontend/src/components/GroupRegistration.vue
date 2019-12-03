<template>
    <div class="container">
        <div class="section">
            <h4>
                Создание группы
            </h4>
            <div class="divider"></div>
        </div>

        <div class="row">
            <div class="col s12">
                <div class="row">
                    <div class="input-field col s4">
                        <input v-model="group.name" id="name" type="text" class="validate">
                        <label for="name">name</label>
                    </div>
                </div>

                <div class="section">
                    <button v-on:click="send" class="btn waves-effect waves-light indigo" name="action">Submit
                        <i class="material-icons right">send</i>
                    </button>
                </div>
            </div>
        </div>

        <div class="divider"></div>


    </div>
</template>

<script>
    export default {
        name: "GroupRegistration",
        data() {
            return {
                group: {
                    "name": null,
                }
            };
        },
        methods: {
            send: function () {
                var path = this.$root.path + "groups/";
                this.$root.$http.post(path, this.group)
                    .then(
                        () => {
                            alert("Группа успешно содана");
                            this.$router.push("groups");
                        }
                    )
                    .catch(error => {
                        alert("Возникли ошибки");
                        console.log(error);
                        this.errors = true;
                    })
                    .finally(() => {
                    });
            }
        }
    }
</script>

<style scoped>

</style>