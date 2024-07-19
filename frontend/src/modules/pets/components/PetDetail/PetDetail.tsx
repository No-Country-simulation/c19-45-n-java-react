import React from 'react'
import BannerPet from './BannerPet'
import PetDetailInfo from './PetDetailInfo';
import PetContactInfo from './PetContactInfo';
import PetDetailImages from './PetDetailImages';

export default function PetDetail() {
  return (
    <div className="min-h-screen items-center justify-center ">
       <BannerPet/>
       <div className="grid grid-cols-1 sm:grid-cols-2 gap-4 md:gap-8 mb-8">
          <PetDetailInfo title="ESPECIES" value="Gato"/>
          <PetDetailInfo title="RAZA" value="Persa"/>
          <PetDetailInfo title="VACUNAS AL DIA" value="Si"/>
          <PetDetailInfo title="ESTERILIZACION" value="Si"/>
       </div>
       <PetContactInfo/>
       <PetDetailImages/>
    </div>
  )
}
