package edu.eci.cvds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import edu.eci.cvds.guess.Configuration;
import edu.eci.cvds.repository.ConfigurationRepository;

@Service

public class ConfigurationService {
    
	private final ConfigurationRepository configurationRepository;
        
        
        public ConfigurationService(ConfigurationRepository configurationRepository) {
            this.configurationRepository = configurationRepository;
        }
        public Configuration getConfiguration(String propiedad){
            return configurationRepository.findById(propiedad);
        }
        public Configuration addConfiguration(Configuration configuration) {
            return configurationRepository.save(configuration);
        }
        public Configuration updateConfiguration(Configuration configuration){
            if(configurationRepository.existsById(configuration.getId())){
                return configurationRepository.save(configuration);
            }
            return null;
        }
        public void deleteConfiguration(Long propiedad){
            configurationRepository.deleteById(propiedad);
        }

        public List<Configuration> getAllConfigurations() {
            return configurationRepository.findAll();
        }
}