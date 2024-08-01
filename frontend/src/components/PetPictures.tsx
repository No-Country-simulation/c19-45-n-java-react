import Image from "next/image";

interface IPicture {
  pictures: string[];
}

export const PetPictures = ({ pictures }: IPicture) => {
  return (
    <section>
      <h1 className="font-bold text-3xl">Fotografías de Mascota</h1>
      <div className="grid grid-cols-3 gap-8 mt-4">
        {pictures.map((picture: string, i: number) => (
          <Image
            key={i}
            src={picture}
            width={100}
            height={100}
            alt="Mascota"
            className="shadow-lg w-full h-[240px] object-cover rounded-lg bg-[#FFCD82]"
          />
        ))}
      </div>
    </section>
  );
};
