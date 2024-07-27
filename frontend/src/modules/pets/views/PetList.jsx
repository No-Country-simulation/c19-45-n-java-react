import React from "react";
import "./PetList.css";
import { BiBorderRadius } from "react-icons/bi";
import Link from "next/link";

const PetList = () => {
  return (
    <div className="containerPetList">
      <div className="contTitle">
        <h1 className="title">Mis Mascotas</h1>
        <Link href="/">
          <button className="buttonTitle">Crear Mascotas</button>
        </Link>
      </div>
      {/*-------------------------------cardPets--------------------------------*/}
      <div className="cardPets">
        <div className="card">
          <div className="imagesPet">
            <img
              src="https://s3-alpha-sig.figma.com/img/8880/9c74/e84cc1d8360f259c034e385120e96804?Expires=1722816000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=GOfx4vknp-mxYChTvJttFr6qsErMgDCmORz9tHlOWbO60ZH6sjwk7smHn3nGxG7fVRM6UlQFm1jjduB0387XEWB8XT7mvrQjr-aL4tfpMy4lXozGf~4VJPt1vGeQ4msJxGQ1E0lUMMQdkKbVBe~fhk-fAlkQUWj9J-aMp-AEgSg6AejMY5eG37CXovqXQT0TFRFfs7GjkVqQjY5-68G0dS-XpHupg4KpWNvDEb2uxK6xqYpiDqlIZucvK8bpUNhPG7UrBurQswlHgd-5Y9XKukv2A64WUYlSAaqZfhArFJ9AfaQGE2AA3NH5yxPd1fEmkqftfei4AwlG~oeB8ir~1w__"
              alt=""
              className="image"
            />
          </div>
          <div className="infoPet">
            <div className="namePet">
              <h2>Gringa</h2>
            </div>
            <div className="descripcionPet">
              <div className="Left ">
                <div className="info">
                  <h1 className="bold">Edad:</h1>
                  <p>2 años</p>
                </div>
                <div className="info">
                  <span className="bold">Especie:</span>
                  <p>--</p>
                </div>
                <div className="info">
                  <span className="bold">Vacunas al día:</span>
                  <p>--</p>
                </div>
              </div>
              <div className="Right">
                <div className="info">
                  <span className="bold">Sexo:</span>
                  <p>Hembra</p>
                </div>
                <div className="info">
                  <span className="bold">Raza:</span>
                  <p>--</p>
                </div>
                <div className="info">
                  <span className="bold">Esterelización:</span>
                  <p>--</p>
                </div>
              </div>
            </div>
          </div>
          <div className="contButton">
            <button className="Button">Editar</button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default PetList;
