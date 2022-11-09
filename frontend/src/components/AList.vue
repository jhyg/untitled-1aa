
<template>

  <div>
    <a v-bind:key="element.id" v-model="elements[index]" v-for='(element, index) in elements' @change="update" @remove="remove"></a>

    <h2>Add New a</h2>
    <a v-model="newElement" isEditable=true isNew=true @add="add"></a>
  </div>

</template>

<script>
  import $ from "jquery";
  import a from './A';

  export default {
    name: 'aList',
    components: {
      a
    },

    data() {
      return {
        elements: [],
        newElement: {
          //titleField: 'New Course'
        }
      }
    },
    created() {
      var me = this;

      try{
        $.ajax(
          {
            url: window.backendHost + ":" + window.backendPort + '/as',
            success: function(result){
              me.elements = result._embedded.as;
            },
            fail: function(jqXHR, textStatus, errorThrown){
              console.log(jqXHR)
              alert(textStatus+ " : \n" + errorThrown)
            }
          }
        )
      }catch(e){
        alert(e);
      }

    },

    computed: {
      
    },

    watch: {
      
    },

    methods: {

      update(element){
        try{
          $.ajax({
            url: window.withBackend(element._links.self.href),
            method: 'PUT',
            contentType: "application/json",
            data: JSON.stringify(element),
            success:
              function(){
              alert('Successfully Updated!');
            },
            fail: function(jqXHR, textStatus, errorThrown){
              console.log(jqXHR)
              alert(textStatus+ " : \n" + errorThrown)
            }
          })
        }catch(e){
          alert(e);
        }

      },

       add(element){
          var me = this;

          try{
            $.ajax({
              url: window.withBackend("/as"),
              method: 'POST',
              contentType: "application/json",
              data: JSON.stringify(element),
              success:
                function(result){
                me.elements.push(result);

                me.newElement = {};

                alert('Successfully Added!');
              },
              fail: function(jqXHR, textStatus, errorThrown){
                console.log(jqXHR)
                alert(textStatus+ " : \n" + errorThrown)
              }
            })
          }catch(e){
            alert(e);
          }

       },

       remove(element){
        var me = this;

        try{
          $.ajax({
            url: window.withBackend(element._links.self.href),
            method: 'DELETE',
            success:
              function(){
                var index = me.elements.indexOf(element);
                me.elements.splice(index, 1);
              },
              fail: function(jqXHR, textStatus, errorThrown){
                console.log(jqXHR)
                alert(textStatus+ " : \n" + errorThrown)
              }
          })

        }catch(e){
          alert(e);
        }


       }
    }
  }
</script>
