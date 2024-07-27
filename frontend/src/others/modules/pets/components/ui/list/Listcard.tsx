import Image from 'next/image';

interface ListcardProps {
  imageSrc: string;
  title: string;
  sexo: string;
  edad: string;
  description: string;
  buttonText: string;
  onButtonClick?: () => void;
}

export default function Listcard({
  imageSrc,
  title,
  sexo,
  edad, 
  description,
  buttonText,
  onButtonClick,
}: ListcardProps) {
  return (
    <div className="card bg-orange-300 w-80 shadow-xl m-10">
      <figure className="px-4 pt-4">
        <Image
          className="max-w-sm rounded-lg"
          src={imageSrc}
          width={250}
          height={250}
          alt={title}
        />
      </figure>
      <div className="card-body items-center text-center">
        <h2 className="card-title font-bold text-2xl">Nombre : {title}</h2>
        <p className='font-bold'>Sexo : {sexo}</p>
        <p className='font-bold'> Edad : {edad} años</p>
        <p className='font-bold'> Descripcion : {description}</p>
        <div className="card-actions">
          <button
            className="btn btn-primary font-extrabold bg-black hover:bg-gray-600 w-52"
            onClick={onButtonClick}
          >
            {buttonText}
          </button>
        </div>
      </div>
    </div>
  );
}



