<template>
  <div>
    <el-container>
      <el-header height="">
        <navigation></navigation>
        <div style="margin: 20px 0;"></div>
        <el-input
          type="textarea"
          placeholder="标题"
          autosize
          v-model="publishParam.title"
        ></el-input>
      </el-header>
      <div style="margin: 5px 0;"></div>
      <el-main height="">
        <el-input
          type="textarea"
          :rows="50"
          placeholder="内容"
          v-model="publishParam.content"
        >
        </el-input>
      </el-main>
      <el-footer height="">
        <el-button>取 消</el-button>
        <el-button type="primary">确 定</el-button>
      </el-footer>
    </el-container>
  </div>
</template>

<script>
import navigation from "@/components/navigation";
export default {
  data() {
    return {
      publishParam: {
        userName: this.$route.params.userName,
        title: "",
        content: ""
      }
    };
  },
  components: {
    navigation
  },
  methods: {
    submit() {
      title = this.pubishParma.title;
      content = this.pubishParma.content;
      if (title == "" || content == "") {
        alert("标题或者内容不能为空");
      } else {
        this.$axios({
          method: "post",
          url: "/api/publish/submit",
          data: this.pubishParma
        }).then(response => {
          if (response.data.data) {
            alert("成功");
          } else {
            alert("失败");
          }
        });
      }
    }
  }
};
</script>

<style scoped>
</style>