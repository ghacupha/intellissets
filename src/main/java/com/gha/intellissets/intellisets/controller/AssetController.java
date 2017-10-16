package com.gha.intellissets.intellisets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gha.intellissets.intellisets.model.Asset;
import com.gha.intellissets.intellisets.model.service.AssetService;

@Controller
public class AssetController {
	
	@Autowired private AssetService assetService;
	
	@RequestMapping("/")
	public String assetList(Model model) {
		
		model.addAttribute("assets",assetService.findAll());
		
		return "assetlist";
	}
	
	@RequestMapping("asset/new")
	public String newAsset(Model model) {
		
		model.addAttribute("asset", new Asset());
		
		return "assetform";
	}
	
	@RequestMapping(value="asset", method=RequestMethod.POST)
	public String saveAsset(Asset asset) {
		
		assetService.addAsset(asset);
		
		return "redirect:/asset/"+asset.getId();
	}
	
	@RequestMapping("asset/edit/{id}")
	public String edit(@PathVariable Integer id, Model model){
		
	    model.addAttribute("asset", assetService.findById(id));
	    
	    return "assetform";
	}
	
    @RequestMapping("asset/{id}")
    public String showAsset(@PathVariable Integer id, Model model){
    	
        model.addAttribute("asset", assetService.findById(id));
        
        return "assetshow";
    }
    
    @RequestMapping("asset/delete/{id}")
    public String delete(@PathVariable Integer id){
    	
        assetService.deleteAsset(id);
        
        return "redirect:/";
    }

}
