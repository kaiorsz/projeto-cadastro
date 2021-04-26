import {Component} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  codeSeller: string;
  nameSeller: string;

  codeClient: string;
  nameClient: string;
  codeSellerClient: string;

  codeProduct: string;
  nameProduct: string;

  constructor(private http: HttpClient) {

  }

  title = 'front-end-max';

  returnErrorMessage(nameError: Array<string>) : string{
    let messageError = null;
    nameError.forEach(function (value) {
        messageError = "- " + nameError;
    })
    return messageError;
  }

  validateSaveSeller(){
    let arr: Array<string> = [];
    if (this.nameSeller == ""){
      arr.push("O nome do vendedor não pode estar vazio! \n")
    }
    if(this.codeSeller == ""){
      arr.push("O código do vendedor não pode estar vazio! \n")
    }
    if(arr.length == 0){
      this.saveSeller();
    }
    else{
      alert(this.returnErrorMessage(arr));
    }
  }
  validateSaveClient(){
    let arr: Array<string> = [];
    if (this.nameClient == ""){
      arr.push("O nome do cliente não pode estar vazio! \n")
    }
    if(this.codeClient == ""){
      arr.push("O código do cliente não pode estar vazio! \n")
    }
    if(this.codeSellerClient == ""){
      arr.push("O código do vendedor do cliente não pode estar vazio! \n")
    }
    if(arr.length == 0){
      this.saveClient();
    }
    else{
      alert(this.returnErrorMessage(arr));
    }

  }
  validateSaveProduct(){
    let arr: Array<string> = [];
    if (this.nameProduct == ""){
      arr.push("O nome do produto não pode estar vazio! \n")
    }
    if(this.codeProduct== ""){
      arr.push("O código do produto não pode estar vazio! \n")
    }
    if(arr.length == 0){
      this.saveProduct();
    }
    else{
      alert(this.returnErrorMessage(arr));
    }
  }

  async saveSeller() {
    try{
      await this.http.post('http://localhost:8080/seller', {
        name: this.nameSeller,
        code: this.codeSeller
      }).toPromise();
      alert('Vendedor cadastrado com sucesso!');
    } catch (e ){
      alert("Erro ao cadastrar vendedor");
    }
  }

  async saveClient() {
    try{
      await this.http.post('http://localhost:8080/client', {
        name: this.nameClient,
        code: this.codeClient,
        codeSeller: this.codeSellerClient
      }).toPromise();
      alert('Cliente cadastrado com sucesso!');
    }catch (e ){
      alert("Erro ao cadastrar cliente");
    }
  }

  async saveProduct() {
    try{
      await this.http.post('http://localhost:8080/product', {
        name: this.nameProduct,
        code: this.codeProduct
      }).toPromise();
      alert('Produto cadastrado com sucesso!');
    }catch (e ){
      alert("Erro ao cadastrar produto");
    }
  }


}

