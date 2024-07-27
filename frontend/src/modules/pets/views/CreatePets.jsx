import React from "react";
import "./CreatePets.css";
import { BiArrowBack } from "react-icons/bi";
function CreatePets() {
  return (
    <div className="contCreatePets">
      <div className="titleCreate">
        <BiArrowBack size={50} className="icon" />
        <h1 className="createPet">Crear Mascota</h1>
      </div>
      {/*------------------Informacion Basico ------------------------------- */}
      <div className="containerFormBasico">
        <h1 className="titleInfoBasico">Basico</h1>
        {/*--------------------Nombres----------------------------- */}
        <div className="campo">
          <label htmlFor="" className="labelForm">
            Nombres
          </label>
          <input
            type="text"
            className="inputForm"
            placeholder="Ingresar nombres"
          />
        </div>
        {/*--------------------------Especie----------------------- */}
        <div className="campo">
          <label htmlFor="" className="labelForm">
            Especie
          </label>
          <select className="selectForm">
            <option value="1">Seleccione Especie</option>
            <option value="1">Opción 1</option>
            <option value="2">Opción 2</option>
            <option value="3">Opción 3</option>
          </select>
        </div>

        {/*----------------------Raza--------------------------- */}
        <div className="campo">
          <label htmlFor="" className="labelForm">
            Raza
          </label>
          <input
            type="text"
            className="inputForm"
            placeholder="Ingresar Raza"
          />
        </div>
        {/*-----------------------Edad-------------------------- */}
        <div className="campo">
          <label htmlFor="" className="labelForm">
            Edad
          </label>
          <input
            type="text"
            className="inputForm"
            placeholder="Ingresar Edad"
          />
        </div>
        {/*-----------------------Sexo-------------------------- */}
        <div className="campo">
          <label htmlFor="" className="labelForm">
            Sexo
          </label>
          <select className="selectForm">
            <option value="1">Seleccione Sexo</option>
            <option value="1">Opción 1</option>
            <option value="2">Opción 2</option>
            <option value="3">Opción 3</option>
          </select>
        </div>
      </div>
      {/*------------------------Linea------------------------- */}
      <div className="line"></div>
      {/*----------------------Informacion Salud--------------------------- */}
      <div className="containerFormBasico">
        <h1 className="titleInfoBasico">Salud</h1>
        {/*-----------------------Vacunas al día-------------------------- */}
        <div className="campo">
          <label htmlFor="" className="labelForm">
            Vacunas al día
          </label>
          <select className="selectForm">
            <option value="1">Seleccione</option>
            <option value="1">Opción 1</option>
            <option value="2">Opción 2</option>
            <option value="3">Opción 3</option>
          </select>
        </div>
        {/*-----------------------Esterilización-------------------------- */}
        <div className="campo">
          <label htmlFor="" className="labelForm">
            Esterilización
          </label>
          <select className="selectForm">
            <option value="1">Seleccione</option>
            <option value="1">Opción 1</option>
            <option value="2">Opción 2</option>
            <option value="3">Opción 3</option>
          </select>
        </div>
      </div>
      {/*------------------------Linea------------------------- */}
      <div className="line"></div>
      {/*----------------------Informacion Visual--------------------------- */}
      <div className="containerFormBasico">
        <h1 className="titleInfoBasico">Visual</h1>
        {/*------------------------contenedor de imagenes------------------------- */}
        <div className="containerImageVisual">
          {/*------------------------Carta de imagen 1 ------------------------- */}
          <div className="cardImage">
            <div className="image">
              <img src="" alt="" />
            </div>
            <button className="buttonUploadImage">Subir Imagen</button>
          </div>
          {/*------------------------Carta de imagen 2 ------------------------- */}
          <div className="cardImage">
            <div className="image">
              <img src="" alt="" />
            </div>
            <button className="buttonUploadImage">Subir Imagen</button>
          </div>
          {/*------------------------Carta de imagen 3 ------------------------- */}
          <div className="cardImage">
            <div className="image">
              <img src="" alt="" />
            </div>
            <button className="buttonUploadImage">Subir Imagen</button>
          </div>
        </div>
        <div className="savePet">
          <button className="buttonSavePet">Crear Mascota</button>
        </div>
      </div>
    </div>
  );
}

export default CreatePets;
