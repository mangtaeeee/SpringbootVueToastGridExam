<template>
    <div >
        <b-form>
            <div class="insert_board">
                <h3> 사원 등록</h3>
                <div class="m-3">
                    <label>생성일시: <b-input type="date" name="createDt" v-model="boardinsert.createDt"  /></label>
                    <label>생성ID: <b-input type="text" name="createId" v-model="boardinsert.createId"  /></label>
                    <label>비밀번호: <b-input type="password" name="pwd" v-model="boardinsert.pwd"  /></label>
                    <label>사원ID: <b-input type="text" maxlength="4" name="emplyId" v-model="boardinsert.emplyId"  /></label>
                    <label>전화번호: <b-input type="text" name="phone" v-model="boardinsert.phone"  /></label>
                </div>
                <div  class="m-3">
                    <label>사원이름: <b-input type="text"  name="emplyNm" v-model="boardinsert.emplyNm"  /></label>
                    <label>사원번호: <b-input type="number" min="0"  maxlength="3" name="emplyNo" v-model="boardinsert.emplyNo" /></label>
                    <label>수정일시: <b-input type="date" name="modDt" v-model="boardinsert.modDt"  /></label>
                    <label>수정아이디: <b-input type="text" name="modId" v-model="boardinsert.modId"  /></label>
                    <b-button variant="outline-primary" class="m-1" small @click="insertBoard()">저장</b-button>
                </div>
                <hr />
                <div>
                    <h3>검색</h3> 
                    <b-input-group class="w-25">
                        <template #prepend>
                            <b-select type="select" class="ml-3" :options="options" v-model="boardinsert.type" >
                            </b-select>
                        </template>
                        <b-form-input :disabled="boardinsert.type == 'non'" v-model="boardinsert.content" name="content"></b-form-input>
                        <b-input-group-append>
                            <b-button size=""  @click="$list()" variant="outline-success">조회</b-button>
                        </b-input-group-append>
                    </b-input-group>
                </div>
            </div>
        </b-form>
        <hr />
        <div>
            <div class="con_title">
                <h2>사원명단</h2>      
            </div>
            <div>
                <grid v-if="this.retunData.length > 0" 
                    :data="this.retunData"
                    :columns="this.boardList.columns"
                    id="boardList2"
                    ref="boardList2"
                    v-bind="boardList" 
                    :scrollX="scrollX"
                    :scrollY="scrollY">
                </grid>
            </div>
        </div>
    </div>
</template>

<script>
import customAxios from "@/plugins/customAxios";


export default {
    name: "ManDashBoard",

    methods:{
        //조회
        $list(){
            this.$serch();
        },
        $serch(){
            
            customAxios.get("api/dashboard",{
                params:{
                    type : this.boardinsert.type,
                    content : this.boardinsert.content
                }
            })
                .then(response => {
                    if(this.retunData != null){
                        this.$refs.boardList2.invoke("resetData",response); //vue 에서 $resf는 마운트 된 후에 접근이 가능하다 돔에 직접 접근해 조작한다.
                    } else if(this.returnData == null){
                        this.retunData = response;
                    }
                    
                    console.log(this.retunData);
                })
                .catch(error=>{
                    console.log(error);
                }); 
        },

        insertBoard(){
            customAxios.post("api/insertboard",{
                createDt:this.boardinsert.createDt,//생성일시
                createId:this.boardinsert.createId,//생성ID
                pwd:this.boardinsert.pwd,     //비밀번호
                emplyId:this.boardinsert.emplyId,//사원ID
                emplyNm:this.boardinsert.emplyNm,//사원이름 
                emplyNo:this.boardinsert.emplyNo,//사원번호
                modDt:this.boardinsert.modDt,//수정일시
                modId:this.boardinsert.modId,//수정아이디
                phone:this.boardinsert.phone,//전화번호
            })
                .then(response =>{
                    console.log(response);
                    if (response == "success"){ // 반환값이"success" 일때 
                        this.$router.go(this.$router.currentRoute);
                    }
                })
                .catch(error=>{
                    console.log(error);
                    alert("입력이 잘못 되었습니다 다시 입력해주세요.");
                });
        }
    },

    data(){
        return{
            gridProps:null,
            scrollX: false,
            scrollY: false,            
            options:[ //select를 위한 선언
                {value:"non",text:"선택"},
                {value:"emplyNm",text:"사원명"},
                {value:"emplyId",text:"사원ID"},
            ],
            boardinsert:{  //null 값 적용을 위해 기본값을 null 로 선언
                createDt:null,//생성일시
                createId:null,//생성ID
                pwd:null,     //비밀번호
                emplyId:null,//사원ID
                emplyNm:null,//사원이름 
                emplyNo:null,//사원번호
                modDt:null,//수정일시
                modId:null,//수정아이디
                phone:null,//전화번호
                content:"",
                type:"non"
            },
            retunData: [],
        };
    },

    created() { //처음 데이터를 서버에서 받아와 페이지 로딩전 데이터 초기화 (틀)
        customAxios.get("api/dashboard")
            .then(response => { 
                this.retunData = response;
                console.log(this.retunData);
            })
            .catch(error=>{
                console.log(error);
            }); 
        this.boardList = {
            name: "boardList2",
            columns :[
                { header: "생성일시", name: "createDt", align: "center",filter: {
                    type: "date",
                    operator: "OR"
                }},
                { header: "생성ID", name: "createId", align: "center"},
                { header: "사원ID", name: "emplyId", align: "center"},
                { header: "사원이름", name: "emplyNm", align: "center" ,filter: {
                    type: "select",
                    showApplyBtn: true,
                    showClearBtn: true
                }},
                { header: "사원번호", name: "emplyNo", align: "center"},
                { header: "수정일시", name: "modDt", align: "center"},
                { header: "수정아이디", name: "modId", align: "center"},
                { header: "전화번호", name: "phone", align: "center"}
            ],
            
        };
    
    },

    mounted(){ 
        this.boardList2 = this.$refs.boardList2; //그리드 셋팅 
    },
    
};
</script>
<style >
    input[type="text"],[type="date"],[type="number"],[type="password"]{
        border: 1px solid black;
        width: 90%
    }

    select {
        height: 33px;
        border: 1px solid black;
    }
    

</style>

